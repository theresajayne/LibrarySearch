package com.gitlab.theresajayne.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class ConfigTest
{

    @Test
    public void testConfig()
    {
        Config config = new Config();
        assertNotNull(config);
    }

    @Test
    public void testFiles()
    {
        Config config = new Config();
        assertNotNull(config.getEntry("inputFolder"));
        assertThat(config.getEntry("inputFolder"),is("F:\\books\\import"));
    }
}
