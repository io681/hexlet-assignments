package exercise.mapper;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/* Аннотация @Mapping позволяет указать правила преобразования свойств.
Самый частый случай — это когда имя свойства в исходном объекте не совпадает с целевым.
В аннотации source указывает на объект, который передается как параметр, target — это объект,
возвращаемый из метода.
*/

// BEGIN
@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ProductMapper {
    //конвертация из ProductCreateDTO в  Product после create
    @Mapping(target = "name", source = "title")
    @Mapping(target = "cost", source = "price")
    @Mapping(target = "barcode", source = "vendorCode")
    public abstract Product map(ProductCreateDTO productCreateDTO);

    //конвертация из Product в  ProductDTO для вывода
    @Mapping(target = "price", source = "cost")
    @Mapping(target = "title", source = "name")
    @Mapping(target = "vendorCode", source = "barcode")    // Здесь можно применить обратное наследование
    public abstract ProductDTO map(Product product);

    @Mapping(target = "cost", source = "price")
    public abstract void update(ProductUpdateDTO productUpdateDTO, @MappingTarget Product product);
}
// END
