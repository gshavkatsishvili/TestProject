import groovy.json.JsonSlurper

import java.net.HttpURLConnection

class TestAPI {
    def static url = "https://reqres.in/api/"
    JsonSlurper slurper = new JsonSlurper()

    TestAPI() {

    }

    public getMethod(def path) {
        def request = new URL(url + path).openConnection()
        def statusCode = request.getResponseCode()
        if (statusCode == 200) {
            def responseBody = request.getInputStream().getText()
            println("Unparsed json: " + responseBody)
            def parsedJson = slurper.parseText(responseBody)
            println("Parsed json: " + parsedJson)
            return parsedJson
        } else {
            def responseBody = request.getErrorStream().getText()
            def parsedJson = slurper.parseText(responseBody)
            return parsedJson
        }
    }

    // "/" იმიტომ უნდა რო გამოყოს მისამართი path-ისგან და id-ისგან. მაგ: https://reqres.in/api/User/2
    public getMethodById(def path, def id) {
        def request = new URL(url + path + "/" + id).openConnection()
        def statusCode = request.getResponseCode()
        if (statusCode == 200) {
            def responseBody = request.getInputStream().getText()
            def parsedJson = slurper.parseText(responseBody)
            println("Parsed json: " + parsedJson)
            return parsedJson
        } else {
            def responseBody = request.getErrorStream().getText()
            def parsedJson = slurper.parseText(responseBody)
            println("Parsed json: " + parsedJson)
            return parsedJson
        }
    }
}