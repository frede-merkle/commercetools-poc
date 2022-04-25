import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;

import java.util.Date;

public class RestClient {
    public static ProjectApiRoot apiRoot;
    public static ProjectApiRoot getInstance() {
        if (apiRoot == null) {
            apiRoot = createProjectClient();
        }
        return apiRoot;
    }

    private static ProjectApiRoot createProjectClient() {
        // Project scoped ApiRoot config for Europe projects
        long current = System.currentTimeMillis();
        System.out.println("Creating API client...");
        ProjectApiRoot apiRoot = ApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId("f0Tz9G_L2K_yl8L3zB1iBJCr")
                                .withClientSecret("nG6B8WoLoNtthGvbSQd5R2epiNQ5Mt_V")
                                .build(),
                        ServiceRegion.GCP_EUROPE_WEST1)
                .build("commertools-poc");
        long now = new Date().getTime()-current;
        System.out.println("API client created in " + now + "ms");
        return apiRoot;
    }
}
