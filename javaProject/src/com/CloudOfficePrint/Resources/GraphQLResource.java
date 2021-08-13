package com.CloudOfficePrint.Resources;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Set;

/**
 * Class for working with a GraphQL endpoint as Resource.
 */
public class GraphQLResource extends ExternalResource {

    private String query;

    /**
     * @return GraphQL query.
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query GraphQL query.
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * Resource from a GraphQL endpoint.
     * 
     * @param endpoint URL of the data source from where the JSON needs to be read.
     * @param query    GraphQL query.
     * @param fileName Name of the output file.
     * @param headers  HTTP headers, e.g.
     *                 [{"Content-Type":"application/json"},{"Custom-Auth-Token":"xysazxklj4568asdf46a5sd4f"}]
     * @param auth     Basic authentication i.e. 'user:password' to compute an
     *                 Authorization header.
     */
    public GraphQLResource(String endpoint, String query, String fileName, JsonArray headers, String auth) {
        super("graphql", endpoint, fileName, headers, auth);
        setQuery(query);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON() {
        JsonObject json = super.getJSON();
        json.addProperty("query", getQuery());
        return json;
    }

    /**
     * Cannot be used for a resource.
     * 
     * @return null
     */
    @Override
    public Set<String> getTemplateTags() {
        return null;
    }
}
