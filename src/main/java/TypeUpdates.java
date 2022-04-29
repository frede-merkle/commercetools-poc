import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.product_type.*;

import java.util.Locale;


public class TypeUpdates {
    private final static ProjectApiRoot restClient = RestClient.getInstance();

    public static void main(String[] args) {
        addCustomProductType();
    }

    public static void addCustomProductType() {
        final AttributeDefinitionDraft attribute = AttributeDefinitionDraft.builder()
                .isRequired(true)
                .type(AttributeTypeBuilder::booleanBuilder)
                .name("customProduct")
                .label(LocalizedString.of(Locale.ENGLISH, "Product is Custom"))
                .build();

        final ProductTypeUpdate productType = ProductTypeUpdate.builder()
                .actions(ProductTypeUpdateAction.addAttributeDefinitionBuilder()
                        .attribute(attribute)
                        .build())
                .version(2L)
                .build();

        final ProductType body = restClient.productTypes().withKey("main").post(productType).executeBlocking().getBody();
        System.out.println("Result: " + body.getKey() + " updated");
    }
}
