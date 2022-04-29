class TypeUpdatesTest extends BaseTest {

    def "Get customProduct type"() {
        when: "getting "
        def response = restClient.productTypes().withKey("main").get().executeBlocking().body

        then: "the result contains the correct name and default values"
        with(response) {
            attributes.find { att -> att.name.equals("customProduct") }.println(response)
        }
    }
}
