/**
 *     Copyright (C) 2009-2011  Jack A. Rider All rights reserved.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 */

package org.xmlportletfactory;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlportletfactory.exceptions.NoParentOrCurrentPathFound;
import org.xmlportletfactory.exceptions.NoResourcesFoundException;
import org.xmlportletfactory.gui.MainWindow;
import org.xmlportletfactory.utils.CopyUtil;
import org.xmlportletfactory.utils.VelocityFileNameFilter;
import org.xmlportletfactory.utils.XMLUtils;
import org.xmlportletfactory.xml.xmlportletfactory.DefinitionDocument;
import org.xmlportletfactory.xml.xmlportletfactory.DefinitionDocument.Definition;
import org.xmlportletfactory.xml.xmlportletfactory.DefinitionDocument.Definition.Applications;
import org.xmlportletfactory.xml.xmlportletfactory.DefinitionDocument.Definition.Applications.Application;
import org.xmlportletfactory.xml.xmlportletfactory.DefinitionDocument.Definition.Applications.Application.FileDef.Fields;
import org.xmlportletfactory.xml.xmlportletfactory.DefinitionDocument.Definition.Applications.Application.FileDef.Fields.Field;
import org.xmlportletfactory.xml.xmlportletfactory.DefinitionDocument.Definition.CommonData;

/**
 * @author Jack A. Rider
 *
 */
public class XMLPortletFactory {

    private static String _generadorNombre = "XMLPortletFactory";
    private static String _generadorVersion  = "Abril 2012";
    private static String _generadorComentario = "Version Liferay 6.0.6 & 6.1.0 & 6.2.0";
    private static String _author = "Jack A. Rider";
    private static String _parentPath;
    private static String _currentPath;
    private static String _sdk_version;
    private static String portletPath;
    private static File XMLFileDef;
    private static String XSDDef;
    private static String XMLDocPath;
    private static String XSDDocPath;
    private static Document XMLDoc;
    private static Properties properties;

    public static String PORLETSDIR_KEY="xmlportletfactory_porletsdir";
    public static String LASTXML_KEY="xmlportletfactory_lastxml";
    public static String SDK_VERSION="generate_for_sdk_version";
    public static String FILE_SEP = System.getProperty("file.separator");
    public static String PROPERTIES_PATH = FILE_SEP+"Resources"+FILE_SEP+"cfg"+FILE_SEP+"xmlportletfactory.properties";
	private static XPath xpath;

    public XMLPortletFactory () throws Exception{
        Logger.getLogger(XMLPortletFactory.class.getName()).setLevel(Level.ALL);
    	initProperties();
    }

    public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public static void saveProperties() throws IOException {
		properties.store(new FileOutputStream(_currentPath+PROPERTIES_PATH),null);
	}

    // METHOD THAT INITIALIZES THE CLASS AND CALLS ALL OTHERS FUNCTIONS.
    public void startConversion(File file) throws Exception {
        try {
            // DEFINING THE FILE.
            XMLFileDef = file;
            // INITIALIZING THE PROCESS.
            init();
            // GENERATING FILES.
            generate();
        } catch (NoParentOrCurrentPathFound ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SAXException ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception (ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    private void init() throws NoParentOrCurrentPathFound, SAXException, IOException {
        _parentPath=properties.getProperty(PORLETSDIR_KEY);
        _sdk_version=properties.getProperty(SDK_VERSION);
        portletPath = "";
        XSDDef = "xmlportletfactory.xsd";
        XMLDocPath = XMLFileDef.getAbsolutePath();
        XSDDocPath = _currentPath + FILE_SEP +"Resources"+FILE_SEP+"xml"+FILE_SEP + XSDDef;
        XMLUtils.validateAgainstSchema(XMLDocPath, XSDDocPath);
        XMLDoc = XMLUtils.parseXmlFile(XMLDocPath, false);
        xpath = XPathFactory.newInstance().newXPath();
    }

    private void generate() throws Exception {
        try {
            NodeList XMLApplications = (NodeList) xpath.evaluate("/definition/applications/*", XMLDoc, XPathConstants.NODESET);

            for (int i = 0; i < XMLApplications.getLength(); i++) {
                int application = i + 1;
                String XMLApplicationstrClassName = (String) xpath.evaluate("/definition/applications/application[" + (application) + "]/classDef/name", XMLDoc, XPathConstants.STRING);
                System.out.println("Name:" + XMLApplicationstrClassName);
            }
            
            String XMLApplicationstrName = (String) xpath.evaluate("/definition/commonData/projectName", XMLDoc, XPathConstants.STRING);
            // DEFINITION OF THE LOCATION TO ALL THE FILES.
            portletPath = _parentPath + FILE_SEP + XMLApplicationstrName+"-portlet";
            // GENERATING THE STRUCTURE OF THE NEW APPLICATION.
            generateDirectories();
            // GENERATE THE VM TO RUN IT LATER.
            String use_templates = "common";
            generateVelocityFiles(use_templates);
            if (_sdk_version.startsWith("6.0")){
                use_templates = "6.0";
            } else if (_sdk_version.startsWith("6.1")) {
                use_templates = "6.1";
            } else {
            	use_templates = "6.2";
            }
            generateVelocityFiles(use_templates);
        } catch (NoResourcesFoundException ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void initProperties() throws Exception,NoParentOrCurrentPathFound{
    	properties = new Properties();
        try {
        	File currentDir = new File(".");
        	_currentPath = currentDir.getCanonicalPath();
        	//Add file with properties
        	properties.load(new FileInputStream(_currentPath + PROPERTIES_PATH));
        } catch (IOException e) {
        	System.out.println("Error in properties file");
        	throw new Exception(e.getMessage());
        }
    }


    // METHOD TO GENERATE ALL THE NECESSARY DIRS AND SUBDIRS.
    private static void generateDirectories() throws Exception {
            boolean ok = (new File(portletPath)).mkdirs();
            File sourceLocation = new File(_currentPath + FILE_SEP + "Resources"+FILE_SEP+"PortletStructureAndFiles");
            File targetLocation = new File(portletPath);
            CopyUtil.copyDirectoryStructure(sourceLocation, targetLocation);
    }

    private static void generateVelocityFiles(String use_templates) throws NoResourcesFoundException {
        String resourceDir = _currentPath + FILE_SEP + "Resources"+FILE_SEP+"VelocityTemplates_"+use_templates+FILE_SEP+"PortletFiles";
        String[] dirList = new File(resourceDir).list(new VelocityFileNameFilter());
        if (dirList == null) {
            System.out.println("Specified directory (" + resourceDir + ")does not exist or is not a directory.");
            throw new NoResourcesFoundException(resourceDir);
        } else {
            System.out.println(" Found (" + dirList.length + ") entries in folder (" + resourceDir + ")");
            for (int i = 0; i < dirList.length; i++) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Generate File from Velocity Template (" + dirList[i] + ")");
                generateVelocityFile(use_templates,dirList[i]);
            }
            System.out.println("-------------------------------------------------------------");
        }
    }

    private static void generateVelocityFile(String use_templates, String fileName) {
        try {
            // parse xml file agains XMLBeans schema compilation jar
            DefinitionDocument definitionDocument = DefinitionDocument.Factory.parse(new File(XMLDocPath));
            Definition definition = definitionDocument.getDefinition();
            CommonData commonData = definition.getCommonData();
            Applications applications = definition.getApplications();
            for (Application application : applications.getApplicationArray()) {
                String applicationClassName = _parentPath + FILE_SEP + commonData.getProjectName();
                processApplication(use_templates, fileName, commonData, application, applicationClassName, applications);
            }
        } catch (XmlException ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void processApplication(String use_templates, String fileName, CommonData commonData, Application application, String applicationClassName, Applications applications) {
        try {
            Fields fields = application.getFileDef().getFields();

            Field[] field = fields.getFieldArray();
            String[] fieldNames = new String[field.length];
            boolean[] fieldShow = new boolean[field.length];
            String[] fieldTitles = new String[field.length];
            String[] fieldTypes = new String[field.length];

            String[] field_regexp = new String[field.length];

            for (int i = 0; i < field.length; i++) {
                fieldNames[i] = field[i].getName();
                fieldShow[i] = field[i].getShowFieldInView();
                fieldTitles[i] = field[i].getTitle();
                
                fieldTypes[i] = field[i].getType().getDomNode().getChildNodes().item(1).getLocalName();

                if (fieldTypes[i].equalsIgnoreCase("int")) {
                    field_regexp[i] = field[i].getType().getInt().getRegexp();
                }
                if (fieldTypes[i].equalsIgnoreCase("long")) {
                    field_regexp[i] = field[i].getType().getLong().getRegexp();
                }
                if (fieldTypes[i].equalsIgnoreCase("varchar")) {
                    field_regexp[i] = field[i].getType().getVarchar().getRegexp();
                }
                if (fieldTypes[i].equalsIgnoreCase("numeric")) {
                    field_regexp[i] = field[i].getType().getNumeric().getRegexp();
                }
                if (fieldTypes[i].equalsIgnoreCase("float")) {
                    field_regexp[i] = field[i].getType().getFloat().getRegexp();
                }
            }

            Velocity.init();
            VelocityContext vc = new VelocityContext();
            try {
                BufferedReader in = new BufferedReader( new InputStreamReader(new FileInputStream(XMLFileDef), "UTF8"));                
                String str;
                String xml_str = "";
                while ((str = in.readLine()) != null) {
                    xml_str = xml_str + str +"\n";
                }
                in.close();
                vc.put("xml_definition", xml_str);
            } catch (IOException e) {
            }
            
            vc.put("commonData", commonData);
            vc.put("application", application);
            vc.put("applications", applications.getApplicationArray());
            vc.put("fieldNames", fieldNames);
            vc.put("fieldTitles", fieldTitles);
            vc.put("fieldTypes", fieldTypes);
            vc.put("fieldCount", field.length);
            vc.put("date", new java.util.Date());
            vc.put("version", _generadorVersion);
            vc.put("author", _author);
            vc.put("comments", _generadorComentario);
            vc.put("generator", _generadorNombre);
            vc.put("field_regexp", field_regexp);
            vc.put("file_name", application.getFileDef().getName());

            processVelocityTemplate(use_templates, fileName, applicationClassName, vc, application);

            processValidation(use_templates, fileName, commonData, application, applicationClassName, applications);

        } catch (Exception ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void processVelocityTemplate(String use_templates, String fileName, String applicationClassName, VelocityContext vc, Application application) {
        try {
        	// get Velocity Template
            Template template = null;
            template = Velocity.getTemplate( "/Resources/VelocityTemplates_"+use_templates+"/PortletFiles/" + fileName, "UTF-8" );            
            StringWriter sw = new StringWriter();
            
            // merge it with the context variables and process.
        	vc.put("createFile", "true");
        	
            template.merge(vc, sw);
        	
        	// see if needed for portlet generation, maybe is only needed for servicebuilder generation.
            boolean generatePortlet = true;
            if (application.getClassDef().isSetGeneratePortlet()) {
                if (!application.getClassDef().getGeneratePortlet()) {
                	if (vc.get("overrideGeneratePortlet") != "true") {
                		generatePortlet = false;
                	}
                }
            }
            // get results and create correspondent file
            if (vc.get("createName") != null && vc.get("createFile") == "true" && generatePortlet) {
                System.out.println(" --> " + applicationClassName + "-portlet" + vc.get("createPath") + vc.get("createName"));

                // create folder as stated in velocity template "createPath" variable.
                boolean ok = (new File(applicationClassName + "-portlet" + vc.get("createPath"))).mkdirs();
                
                // create file as stated in velocity template "createName" variable
                BufferedWriter outFile = new BufferedWriter(new FileWriter(applicationClassName + "-portlet" + vc.get("createPath") + vc.get("createName")));
                outFile.write(sw.toString());
                outFile.flush();
                outFile.close();
            } else {
                System.out.println(" --> Did not create : " +  vc.get("createName") + ", createFile variable or generatePortlet was not true, .");
            }
            
        } catch (ResourceNotFoundException ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseErrorException ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MethodInvocationException ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(XMLPortletFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void processValidation(String use_templates, String fileName, CommonData commonData, Application application, String applicationClassName, Applications applications) {
        /*
         * Here finds if the application.fileDef.fields.field has a validation in
         * wich case will generate the apropiate DAO, DEF and TBL jsp's needed (getVelocityFilesForValidation)
         * to do so, in the actual application classDef context.
         */
        Fields fields = application.getFileDef().getFields();
        Field[] field = fields.getFieldArray();

        for (int i = 0; i < field.length; i++) {
            String[] filesValidationList = getVelocityFilesForValidation();
            for (String fileValidation : filesValidationList) {
                if (fileName.trim().equalsIgnoreCase(fileValidation)) {
                    if (field[i].isSetValidation()) {
                        for (Application validationApp : applications.getApplicationArray()) {
                            if (validationApp.getClassDef().getName().equalsIgnoreCase(field[i].getValidation().getClassName())) {
                                processApplication(use_templates, fileName, commonData, validationApp, applicationClassName, applications);
                            }
                        }
                    }
                }
            }
        }
    }

    private static String[] getVelocityFilesForValidation() {
        String[] files = {"Portlet_XXXXXXLocalServiceImpl_java.vm"};
        return files;
    }

    /*
     * MAIN
     *
     * AVAILABLE OPTIONS:
     *
     * - CHOOSING A FILENAME FROM FILECHOOSER.
     * - ENTERING THE FILENAME WHEN CALLING THE METHOD.
     */
    public static void main(String[] args) throws Exception {
		final XMLPortletFactory xmlPortletFactory = new XMLPortletFactory();
    	if (args.length == 0) {
    		MainWindow mainWindow = new MainWindow(xmlPortletFactory);
    		mainWindow.setVisible(true);
    		mainWindow.addWindowListener(new WindowAdapter(){
    			public void windowClosing(WindowEvent e) {
    				try {
						xmlPortletFactory.saveProperties();
						System.exit(0);
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
    			}
    		});

        } else {
            // ARGS ENTERED.
           	properties.setProperty(LASTXML_KEY, args[0]);
           	properties.setProperty(PORLETSDIR_KEY, args[1]);
           	properties.setProperty(SDK_VERSION, args[2]);
           	File file = new File(args[0]);
           	xmlPortletFactory.startConversion(file);
        }
    }
}
