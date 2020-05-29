package com.gitlab.theresajayne.entities;

import java.util.UUID;

public abstract class AbstractDocument
{
    protected String title;
    protected String description;
    protected String[] content;
    protected String author;
    protected UUID uuid;
    protected String keywords;

    /**
     * Load the file from disk implemented for each file type separately
     * @param filename The filename to open in the input folder
     */
    public abstract void loadFile(String filename);

    /**
     * return the text contents of the file
     * @return the text content as an array of strings
     */
    public String[] getFileContents()
    {
        return content;
    }

    /**
     * Get Title of document for indexing.
     * @return the title of the document
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Get the Description of the document
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Get UUID
     */
    public UUID getUUID()
    {
        if(uuid == null)
        {
            this.uuid = UUID.randomUUID();
        }
        return this.uuid;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getKeywords()
    {
        return keywords;
    }
}
