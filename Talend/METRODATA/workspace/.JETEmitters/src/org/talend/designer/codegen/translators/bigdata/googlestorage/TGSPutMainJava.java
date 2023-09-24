package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TGSPutMainJava
{
  protected static String nl;
  public static synchronized TGSPutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSPutMainJava result = new TGSPutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_5 = " = null;" + NL + "\ttry {" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\tservice_";
  protected final String TEXT_7 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_8 = "\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Get an free connection from \" + \"";
  protected final String TEXT_11 = "\" + \".\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + NL + "\t       ";
  protected final String TEXT_13 = NL + NL + "\t\t   ";
  protected final String TEXT_14 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = "; ";
  protected final String TEXT_20 = NL + NL + "\t\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_21 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_22 = ",decryptedPassword_";
  protected final String TEXT_23 = ");" + NL + "" + NL + "\t\t\tservice_";
  protected final String TEXT_24 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_25 = ",\" ";
  protected final String TEXT_26 = "\",null);" + NL + "\t\t\tservice_";
  protected final String TEXT_27 = ".getAccountOwner();" + NL + "\t\t";
  protected final String TEXT_28 = NL + "\t\torg.talend.gs.util.GSObjectUtil gsUtil_";
  protected final String TEXT_29 = "=new  org.talend.gs.util.GSObjectUtil();" + NL + "\t\tgsUtil_";
  protected final String TEXT_30 = ".initMimeTypes();" + NL + "\t\tjava.io.File dataDir_";
  protected final String TEXT_31 = "=new java.io.File(";
  protected final String TEXT_32 = ");" + NL + "\t\tjava.util.List<org.jets3t.service.model.GSObject>objects_";
  protected final String TEXT_33 = " =new java.util.ArrayList<org.jets3t.service.model.GSObject>();" + NL + "\t\tjava.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_34 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t\tmap_";
  protected final String TEXT_38 = ".put(";
  protected final String TEXT_39 = ",";
  protected final String TEXT_40 = ");" + NL + "\t\t\t \tlist_";
  protected final String TEXT_41 = ".add(map_";
  protected final String TEXT_42 = ");" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\tjava.util.Map<String,String> fileMap_";
  protected final String TEXT_44 = "=gsUtil_";
  protected final String TEXT_45 = ".genFileFilterList(list_";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = ");" + NL + "\t\t\tobjects_";
  protected final String TEXT_48 = " = gsUtil_";
  protected final String TEXT_49 = ".genObjectByFileMap(fileMap_";
  protected final String TEXT_50 = ");" + NL + "\t\t";
  protected final String TEXT_51 = NL + "\t\t\tobjects_";
  protected final String TEXT_52 = ".genGSObjectList(objects_";
  protected final String TEXT_53 = ", dataDir_";
  protected final String TEXT_54 = ",true,false);" + NL + "\t\t";
  protected final String TEXT_55 = NL + "\t\tfor(org.jets3t.service.model.GSObject obj_";
  protected final String TEXT_56 = ":objects_";
  protected final String TEXT_57 = "){" + NL + "\t\t\tnb_line_";
  protected final String TEXT_58 = " ++;" + NL + "\t\t\tservice_";
  protected final String TEXT_59 = ".putObject(";
  protected final String TEXT_60 = ", obj_";
  protected final String TEXT_61 = ");" + NL + "\t\t}" + NL + "" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_62 = ") {" + NL + "globalMap.put(\"";
  protected final String TEXT_63 = "_ERROR_MESSAGE\",e_";
  protected final String TEXT_64 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_65 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_66 = NL + "\t\t\tif(e_";
  protected final String TEXT_67 = " instanceof org.jets3t.service.ServiceException){" + NL + "\t\t\t\torg.jets3t.service.ServiceException servError_";
  protected final String TEXT_68 = " = (org.jets3t.service.ServiceException)e_";
  protected final String TEXT_69 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_71 = " - Exception in component ";
  protected final String TEXT_72 = ":\" + servError_";
  protected final String TEXT_73 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_75 = ":\");" + NL + "\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_76 = ".getMessage());" + NL + "\t\t\t\tif(servError_";
  protected final String TEXT_77 = ".getErrorCode()!=null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_79 = " - \" + servError_";
  protected final String TEXT_80 = ".getErrorCode());" + NL + "\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_82 = ".getErrorCode());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(servError_";
  protected final String TEXT_83 = ".getErrorMessage()!=null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_84 = ".getErrorMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_85 = ".getErrorMessage());" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_86 = " - \" + e_";
  protected final String TEXT_87 = NL + "\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_88 = ".getMessage());" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_89 = NL + "\t\t\t}finally{" + NL + "\t\t\t\tif(service_";
  protected final String TEXT_90 = " !=null){" + NL + "\t\t\t\t\tservice_";
  protected final String TEXT_91 = ".shutdown();" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_92 = NL + "\t}";
  protected final String TEXT_93 = NL + "\tlong partSizeInBytes_";
  protected final String TEXT_94 = " = (long)";
  protected final String TEXT_95 = " * 1024 * 1024;" + NL + "\t";
  protected final String TEXT_96 = NL + "\tif(partSizeInBytes_";
  protected final String TEXT_97 = " > Integer.MAX_VALUE - 8) {" + NL + "\t\tpartSizeInBytes_";
  protected final String TEXT_98 = " = Integer.MAX_VALUE - 8;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_99 = NL + "  com.google.cloud.storage.Storage storage_";
  protected final String TEXT_100 = " = (com.google.cloud.storage.Storage)globalMap.get(\"service_";
  protected final String TEXT_101 = "\");";
  protected final String TEXT_102 = NL + "com.google.auth.Credentials credential_";
  protected final String TEXT_103 = " = null;" + NL + "try {" + NL + "  credential_";
  protected final String TEXT_104 = " = com.google.auth.oauth2.GoogleCredentials" + NL + "      .fromStream(new java.io.FileInputStream(";
  protected final String TEXT_105 = "));" + NL + "} catch (IOException e_";
  protected final String TEXT_106 = ") {" + NL + "globalMap.put(\"";
  protected final String TEXT_107 = ".getMessage());";
  protected final String TEXT_108 = NL + "     log.error(\"";
  protected final String TEXT_109 = ".\", e_";
  protected final String TEXT_110 = NL + "     throw(e_";
  protected final String TEXT_111 = NL + "}" + NL + "  com.google.cloud.storage.Storage storage_";
  protected final String TEXT_112 = " = com.google.cloud.storage.StorageOptions.newBuilder().setCredentials(credential_";
  protected final String TEXT_113 = ").build().getService();";
  protected final String TEXT_114 = NL + "      final String decryptedAccessTokenGS_";
  protected final String TEXT_115 = ");" + NL + "      com.google.auth.Credentials credential_";
  protected final String TEXT_116 = " = com.google.auth.oauth2.GoogleCredentials.create(" + NL + "              new com.google.auth.oauth2.AccessToken(decryptedAccessTokenGS_";
  protected final String TEXT_117 = ", new Date(Long.MAX_VALUE)));";
  protected final String TEXT_118 = NL + "      class ReinitializeAccessTokenCredentials_";
  protected final String TEXT_119 = " extends com.google.auth.oauth2.GoogleCredentials {" + NL + "            ReinitializeAccessTokenCredentials_";
  protected final String TEXT_120 = " (com.google.auth.oauth2.AccessToken accessToken) {" + NL + "              super(accessToken);" + NL + "            }" + NL + "            public com.google.auth.oauth2.AccessToken refreshAccessToken() throws IOException {" + NL + "                return new com.google.auth.oauth2.AccessToken(";
  protected final String TEXT_121 = ", new Date(Long.MAX_VALUE));" + NL + "            }" + NL + "      }" + NL + "      com.google.auth.Credentials credential_";
  protected final String TEXT_122 = " = new ReinitializeAccessTokenCredentials_";
  protected final String TEXT_123 = "(new com.google.auth.oauth2.AccessToken(";
  protected final String TEXT_124 = NL + "      com.google.cloud.storage.Storage storage_";
  protected final String TEXT_125 = ")" + NL + "            .setProjectId(";
  protected final String TEXT_126 = NL + NL + "\tjava.io.File file_";
  protected final String TEXT_127 = " = new java.io.File(";
  protected final String TEXT_128 = ");" + NL + "\torg.talend.gs.util.GSObjectUtil gsObjectUtil_";
  protected final String TEXT_129 = " = new org.talend.gs.util.GSObjectUtil();" + NL + "" + NL + "\t";
  protected final String TEXT_130 = NL + "\t\tjava.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_131 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\t\t";
  protected final String TEXT_132 = NL + "\t\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_133 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\tmap_";
  protected final String TEXT_134 = ");" + NL + "\t\t\tlist_";
  protected final String TEXT_135 = NL + "\t\tjava.util.Map<String,String> fileMapFromTable_";
  protected final String TEXT_136 = "=gsObjectUtil_";
  protected final String TEXT_137 = ");" + NL + "\t\tjava.util.Map<String, java.io.File> fileMap_";
  protected final String TEXT_138 = " = gsObjectUtil_";
  protected final String TEXT_139 = ".generateFileMap(file_";
  protected final String TEXT_140 = ", fileMapFromTable_";
  protected final String TEXT_141 = ");" + NL + "\t";
  protected final String TEXT_142 = NL + "\t\tjava.util.Map<String, java.io.File> fileMap_";
  protected final String TEXT_143 = NL + "\tfor (java.util.Map.Entry<String, java.io.File> currentFile_";
  protected final String TEXT_144 = " : fileMap_";
  protected final String TEXT_145 = ".entrySet()){" + NL + "\t\tcom.google.cloud.storage.BlobInfo blobInfo_";
  protected final String TEXT_146 = " = com.google.cloud.storage.BlobInfo." + NL + "\t\t\t\tnewBuilder(";
  protected final String TEXT_147 = ", currentFile_";
  protected final String TEXT_148 = ".getKey()).build();" + NL + "\t\tif (partSizeInBytes_";
  protected final String TEXT_149 = " > 0 && java.nio.file.Files.size(currentFile_";
  protected final String TEXT_150 = ".getValue().toPath()) > partSizeInBytes_";
  protected final String TEXT_151 = ") {" + NL + "\t\t\tbyte[] buffer = new byte[(int)partSizeInBytes_";
  protected final String TEXT_152 = "];" + NL + "\t\t\ttry (com.google.cloud.WriteChannel writer_";
  protected final String TEXT_153 = " = storage_";
  protected final String TEXT_154 = ".writer(blobInfo_";
  protected final String TEXT_155 = "); java.io.InputStream inputStreamForUpload_";
  protected final String TEXT_156 = " = java.nio.file.Files.newInputStream(currentFile_";
  protected final String TEXT_157 = ".getValue().toPath())) {" + NL + "\t\t\t\tint curFileLimit_";
  protected final String TEXT_158 = ";" + NL + "\t\t\t\twhile ((curFileLimit_";
  protected final String TEXT_159 = " = inputStreamForUpload_";
  protected final String TEXT_160 = ".read(buffer)) >= 0) {" + NL + "\t\t\t\t\twriter_";
  protected final String TEXT_161 = ".write(java.nio.ByteBuffer.wrap(buffer, 0, curFileLimit_";
  protected final String TEXT_162 = "));" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (IOException e_";
  protected final String TEXT_163 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_164 = ":\" + e_";
  protected final String TEXT_165 = NL + "\t\t\t\t\tthrow e_";
  protected final String TEXT_166 = NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tstorage_";
  protected final String TEXT_167 = ".create(blobInfo_";
  protected final String TEXT_168 = ", java.nio.file.Files.readAllBytes(currentFile_";
  protected final String TEXT_169 = ".getValue().toPath()));" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_170 = " ++;" + NL + "\t\t\t} catch (IOException e_";
  protected final String TEXT_171 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_172 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_173 = "_NB_LINE\", nb_line_";
  protected final String TEXT_174 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String bucketName=ElementParameterParser.getValue(node,"__BUCKET__");

	String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	boolean isUseFilesList=("true").equals(ElementParameterParser.getValue(node, "__USE_FILES_LIST__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
	String partSizeMb = ElementParameterParser.getValue(node, "__PART_SIZE__");

	if(("true").equals(useExistingConn)) {
		List< ? extends INode> nodes =  node.getProcess().getNodesOfType("tGSConnection");
		for (INode ne : nodes) {
			if (connection.equals(ne.getUniqueName())) {
				authType = ElementParameterParser.getValue(ne, "__AUTH_TYPE__");
        break;
			}
		}
	}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if ("USER_ACCOUNT_HMAC".equals(authType)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
		if(("true").equals(useExistingConn)) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_11);
    
			}
		}else{
		
    stringBuffer.append(TEXT_12);
    
	       String passwordFieldName = "__SECRET_KEY__";
	       final String GoogleTracker = org.talend.core.utils.TrackerUtil.getGoogleTracker();
	       
    stringBuffer.append(TEXT_13);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(GoogleTracker);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
		}
		
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
		if(isUseFilesList && files!=null && files.size()>0){
			for (int i=0; i<files.size(); i++) {
				Map<String, String> line = files.get(i);
				
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_42);
    
			}
			
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
		}else{
		
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_54);
    
		}
		
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
		if (("true").equals(dieOnError)) {
		
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
		} else {
		
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
				}
				
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
					}
					
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
					}
					
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
				}
				
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
		}
		
    stringBuffer.append(TEXT_92);
     } else {
  String gsProjectID=ElementParameterParser.getValue(node,"__GS_PROJECT_ID__");

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(partSizeMb);
    stringBuffer.append(TEXT_95);
    
	// We check if it is bigger than the max value allowed by Files.readAllBytes() method
	// and set the max value if it is bigger
	
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
if(("true").equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_101);
     } else {
  if ("SERVICE_ACCOUNT".equals(authType) || "GS_SERVICE_ACCOUNT".equals(authType)) {
    String pathToServerAccoutKeyFile;
    if("SERVICE_ACCOUNT".equals(authType)) {
      pathToServerAccoutKeyFile = ElementParameterParser.getValue(node, "__SERVICE_ACCOUNT_KEY__");
    }else {
      pathToServerAccoutKeyFile = ElementParameterParser.getValue(node, "__GS_SERVICE_ACCOUNT_KEY__");
    }

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(pathToServerAccoutKeyFile);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
     if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
     } 
     if (("true").equals(dieOnError)) { 
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
     } 
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
     } else {
      if (ElementParameterParser.canEncrypt(node, "__GS_ACCESS_TOKEN__")) {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__GS_ACCESS_TOKEN__"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    } else {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append( ElementParameterParser.getValue(node, "__GS_ACCESS_TOKEN__"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append( ElementParameterParser.getValue(node, "__GS_ACCESS_TOKEN__"));
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gsProjectID);
    stringBuffer.append(TEXT_113);
    }
}
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
	if ("/".equals(remotedir.substring(0, 1))){
		remotedir = remotedir.substring(1);
	}

	if(isUseFilesList && files!=null && files.size()>0){
		
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    
		for (int i=0; i<files.size(); i++) {
			Map<String, String> line = files.get(i);
			
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_50);
    
		}
		
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
	} else {
	
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_141);
    
	}
	
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
				}
				if (("true").equals(dieOnError)) {
				
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
				}
				
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
				}
				if (("true").equals(dieOnError)) {
				
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
				}
				
    stringBuffer.append(TEXT_171);
    
}

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_174);
    return stringBuffer.toString();
  }
}
