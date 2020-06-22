package com.gitlab.theresajayne.services;

import com.gitlab.theresajayne.entities.AbstractDocument;
import org.json.simple.JSONObject;

/**
 * Call to the elastic Service using JSON
 */
public class IndexService
{
    public boolean AddDocumentToIndex(AbstractDocument document)
    {
        String payload = prepareJsonDocument(document);
        //Now call the Elastic output
        ElasticService.putToElastic(payload);
        return false;
    }

    private String prepareJsonDocument(AbstractDocument document)
    {
        return getElasticPutJson(document);
    }

    private String getElasticPutJson(AbstractDocument document)
    {
        String author = document.getAuthor();
        String title = document.getTitle();
        String description = document.getDescription();
        String uuid = document.getUUID().toString();
        String keywords = document.getKeywords();
        String[] contents = document.getFileContents();
        StringBuffer buffer = new StringBuffer();
        for(String line:contents)
        {
            buffer.append(line);
        }
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("UUID",uuid);
        jsonObject.put("TITLE",title);
        jsonObject.put("AUTHOR",author);
        jsonObject.put("keywords",keywords);
        jsonObject.put("description",description);
        jsonObject.put("contents",buffer.toString());
        return jsonObject.toJSONString();
    }
}
