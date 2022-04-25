import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.client.QueryUtils;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.product.ProductProjection;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    private final static ProjectApiRoot restClient = RestClient.getInstance();

    public static void main(String[] args) throws Exception {
        queryAllProductIds().forEach(System.out::println);
        queryAllProductNames().forEach(name -> System.out.println(name.get(Locale.ENGLISH)));
    }

    public static List<String> queryAllProductIds() {
        return QueryUtils.queryAll(restClient.productProjections().get(), (productProjections) -> {
                    return productProjections.stream().map(ProductProjection::getId).collect(Collectors.toList());
                }, 100)
                .thenApply(lists -> lists.stream().flatMap(List::stream).collect(Collectors.toList()))
                .toCompletableFuture()
                .join();
    }

    public static List<LocalizedString> queryAllProductNames() {
        return QueryUtils.queryAll(restClient.productProjections().get(), (productProjections) -> {
                    return productProjections.stream().map(ProductProjection::getName).collect(Collectors.toList());
                }, 100)
                .thenApply(lists -> lists.stream().flatMap(List::stream).collect(Collectors.toList()))
                .toCompletableFuture()
                .join();
    }
}
