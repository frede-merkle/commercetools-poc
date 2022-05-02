class TypeUpdatesTest extends BaseTest {

    def "Get customProduct type"() {
        when: "getting main ProductType"
        def response = restClient.productTypes().withKey("main").get().executeBlocking().body

        then: "it has the new customProduct field"
        with(response) {
            attributes.size() > 21 //Default number of attributes is 21
            attributes.find { att -> (att.name == "customProduct") }.println(response)
        }
    }
}
