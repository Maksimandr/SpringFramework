package SpringSecurity.converter;

import SpringSecurity.dto.ProductShortDto;
import SpringSecurity.model.Product;

public class ProductConverter {

    public static ProductShortDto productToProductShortDto(Product product) {
        if (product == null) {
            return null;
        }
        ProductShortDto productShortDto = new ProductShortDto();
        productShortDto.setTitle(product.getTitle());
        productShortDto.setCost(product.getCost());

        return productShortDto;
    }

    public static Product productShortDtoToProduct(ProductShortDto productShortDto) {
        if (productShortDto == null) {
            return null;
        }
        Product product = new Product();
        product.setTitle(productShortDto.getTitle());
        product.setCost(productShortDto.getCost());

        return product;
    }
}
