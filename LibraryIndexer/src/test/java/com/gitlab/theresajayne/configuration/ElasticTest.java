package com.gitlab.theresajayne.configuration;

import com.gitlab.theresajayne.entities.PdfDocument;
import com.gitlab.theresajayne.services.ElasticService;
import com.gitlab.theresajayne.services.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(BlockJUnit4ClassRunner.class)
public class ElasticTest
{
    IndexService service = new IndexService();

    @Test
    public void testPut()
    {
        PdfDocument document = new PdfDocument();
        document.loadFile("F:\\Test.pdf");
        assertTrue(service.AddDocumentToIndex(document));
    }
}
