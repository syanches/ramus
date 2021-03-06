package com.ramussoft.chart;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

public class ChartSaveXMLReader implements XMLReader {

    private ContentHandler handler;

    private ChartSource chartSource;

    public ChartSaveXMLReader(ChartSource chartSource) {
        this.chartSource = chartSource;
    }

    @Override
    public void parse(InputSource input) throws IOException, SAXException {
        if (handler == null)
            throw new SAXException("no content handler");
        handler.startDocument();
        chartSource.save(this);
        handler.endDocument();
    }

    public void endElement(String name) throws SAXException {
        handler.endElement("", name, name);
    }

    public void startElement(String name) throws SAXException {
        startElement(name, new AttributesImpl());
    }

    public void startElement(String name, Attributes attributes)
            throws SAXException {
        handler.startElement("", name, name, attributes);
    }

    public void characters(String text) throws SAXException {
        handler.characters(text.toCharArray(), 0, text.length());
    }

    @Override
    public ContentHandler getContentHandler() {
        return handler;
    }

    @Override
    public void setContentHandler(ContentHandler handler) {
        this.handler = handler;
    }

    @Override
    public DTDHandler getDTDHandler() {
        return null;
    }

    @Override
    public EntityResolver getEntityResolver() {
        return null;
    }

    @Override
    public ErrorHandler getErrorHandler() {
        return null;
    }

    @Override
    public boolean getFeature(String name) throws SAXNotRecognizedException,
            SAXNotSupportedException {
        return false;
    }

    @Override
    public Object getProperty(String name) throws SAXNotRecognizedException,
            SAXNotSupportedException {
        return null;
    }

    @Override
    public void parse(String systemId) throws IOException, SAXException {
    }

    @Override
    public void setDTDHandler(DTDHandler handler) {
    }

    @Override
    public void setEntityResolver(EntityResolver resolver) {
    }

    @Override
    public void setErrorHandler(ErrorHandler handler) {
    }

    @Override
    public void setFeature(String name, boolean value)
            throws SAXNotRecognizedException, SAXNotSupportedException {
    }

    @Override
    public void setProperty(String name, Object value)
            throws SAXNotRecognizedException, SAXNotSupportedException {
    }

}
