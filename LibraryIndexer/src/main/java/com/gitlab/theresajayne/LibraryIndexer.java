package com.gitlab.theresajayne;

import com.gitlab.theresajayne.configuration.Config;

/**
 * Main class for the indexer, Run this application and it will
 * Scan a folder looking for files dropped in and process them for contents.
 * We need to find a way to stop it from pulling files not completely ready to be processed
 * So need to have a scanner main that tries to open a file input stream to see if the file is locked
 * and if not then process said file. We need to get a list of all files in the folder and then process
 * based on file suffix, We need to have pdf, mobi, epub, rtf, doc(x)
 */
public class LibraryIndexer
{
    private static LibraryIndexer instance;
    /**
     * Entry point for program
     * @param args The command line parameters added
     */
    public static void main(String args)
    {
        instance = new LibraryIndexer();
    }

    /**
     * default constructor
     */
    public LibraryIndexer()
    {
        Config config = new Config();
    }
}
