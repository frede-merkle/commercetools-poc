class TypeUpdatesTest extends BaseTest {

    def "Get customProduct type"() {
        when: "getting main ProductType"
        def response = restClient.productTypes().withKey("main").get().executeBlocking().body

        then: "it has the new customProduct field"
        with(response) {
            attributes.find { att -> att.name.equals("customProduct") }.println(response)
        }
    }
}
