package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class TDenormalizeSortedRowMainJava
{
  protected static String nl;
  public static synchronized TDenormalizeSortedRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDenormalizeSortedRowMainJava result = new TDenormalizeSortedRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "currentRowIndex_";
  protected final String TEXT_3 = "++;";
  protected final String TEXT_4 = NL + "boolean sameGroup_";
  protected final String TEXT_5 = " = true;";
  protected final String TEXT_6 = "if(flag_";
  protected final String TEXT_7 = "){" + NL + "\tflag_";
  protected final String TEXT_8 = " = false;";
  protected final String TEXT_9 = NL + "\tgroup_";
  protected final String TEXT_10 = "_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "\t\tdenormalize_";
  protected final String TEXT_15 = ".add(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = ".append(FormatterUtils.format_Date(";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = "));";
  protected final String TEXT_20 = ".append(";
  protected final String TEXT_21 = NL + "}else{";
  protected final String TEXT_22 = NL + "while(true){";
  protected final String TEXT_23 = "if(group_";
  protected final String TEXT_24 = " == null){" + NL + "\tif(";
  protected final String TEXT_25 = " != null){" + NL + "\t\tsameGroup_";
  protected final String TEXT_26 = " = false;" + NL + "\t\tbreak;" + NL + "\t}" + NL + "}else{" + NL + "\tif(group_";
  protected final String TEXT_27 = " == null || !group_";
  protected final String TEXT_28 = ".equals(";
  protected final String TEXT_29 = ")){" + NL + "\t\tsameGroup_";
  protected final String TEXT_30 = " = false;" + NL + "\t\tbreak;" + NL + "\t}" + NL + "}";
  protected final String TEXT_31 = " != ";
  protected final String TEXT_32 = "){" + NL + "\tsameGroup_";
  protected final String TEXT_33 = " = false;" + NL + "\tbreak;" + NL + "}";
  protected final String TEXT_34 = "break;";
  protected final String TEXT_35 = "}" + NL + "if(sameGroup_";
  protected final String TEXT_36 = "){";
  protected final String TEXT_37 = NL + "\tif(!denormalize_";
  protected final String TEXT_38 = ".contains(";
  protected final String TEXT_39 = ")){" + NL + "\t\tdenormalize_";
  protected final String TEXT_40 = ");" + NL + "\t}";
  protected final String TEXT_41 = NL + "\tdenormalize_";
  protected final String TEXT_42 = "}";
  protected final String TEXT_43 = NL + "}" + NL + "" + NL + "int tempCount_";
  protected final String TEXT_44 = " = -1;";
  protected final String TEXT_45 = NL + "if( !sameGroup_";
  protected final String TEXT_46 = " ){" + NL + "\ttempCount_";
  protected final String TEXT_47 = NL + "\temmitArray_";
  protected final String TEXT_48 = "[tempCount_";
  protected final String TEXT_49 = "].";
  protected final String TEXT_50 = " = group_";
  protected final String TEXT_51 = NL + "\ttempSB_";
  protected final String TEXT_52 = ".delete(0, tempSB_";
  protected final String TEXT_53 = ".length());" + NL + "\t" + NL + "\tfor(";
  protected final String TEXT_54 = " tmp_";
  protected final String TEXT_55 = " : denormalize_";
  protected final String TEXT_56 = "){" + NL + "\t\tif(tempSB_";
  protected final String TEXT_57 = ".length() > 0){" + NL + "\t\t\ttempSB_";
  protected final String TEXT_58 = ");" + NL + "\t\t}";
  protected final String TEXT_59 = NL + "\t\ttempSB_";
  protected final String TEXT_60 = ".append(FormatterUtils.format_Date(tmp_";
  protected final String TEXT_61 = ".append(tmp_";
  protected final String TEXT_62 = NL + "\t}" + NL + "\t" + NL + "\tdenormalize_";
  protected final String TEXT_63 = ".clear();" + NL + "\temmitArray_";
  protected final String TEXT_64 = " = tempSB_";
  protected final String TEXT_65 = ".toString();";
  protected final String TEXT_66 = " = denormalize_";
  protected final String TEXT_67 = ".toString();" + NL + "\tdenormalize_";
  protected final String TEXT_68 = ".delete(0, denormalize_";
  protected final String TEXT_69 = ".length());";
  protected final String TEXT_70 = NL + "}";
  protected final String TEXT_71 = NL + "if( currentRowIndex_";
  protected final String TEXT_72 = "  == ";
  protected final String TEXT_73 = ".length());" + NL + "\tfor(";
  protected final String TEXT_74 = NL + "\t}" + NL + "\tdenormalize_";
  protected final String TEXT_75 = NL + "}" + NL + "for(int i_";
  protected final String TEXT_76 = "=0; i_";
  protected final String TEXT_77 = " <= tempCount_";
  protected final String TEXT_78 = "; i_";
  protected final String TEXT_79 = "++){";
  protected final String TEXT_80 = " = emmitArray_";
  protected final String TEXT_81 = "[i_";
  protected final String TEXT_82 = ";    \t\t\t\t";
  protected final String TEXT_83 = "nb_line_";
  protected final String TEXT_84 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    List< ? extends IConnection> conns = node.getIncomingConnections();
    IMetadataTable inMetadata = null;
    String connName = "";
    if(conns != null){
    	for (IConnection conn : conns) { 
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
				connName = conn.getName();
				inMetadata = conn.getMetadataTable();
    			break;
			}
		}
    if (metadata != null && inMetadata != null) { 
		List<IMetadataColumn> columns = inMetadata.getListColumns();
    	Map<String, String> typesMap = new HashMap<String, String>();
    	Map<String, String> patternsMap = new HashMap<String, String>();
    	for(IMetadataColumn column : columns){
    		String type = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    		typesMap.put(column.getLabel(), type);
    		String pattern = ((column.getPattern() == null) || (column.getPattern().trim().length() == 0)) ? "" : column.getPattern();
    		patternsMap.put(column.getLabel(), pattern);
    	}
		String rowCount = ElementParameterParser.getValue(node,"__ROW_COUNT__");//?? i think we need it
		
		List<Map<String, String>> denormalizes = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DENORMALIZE_COLUMNS__");
        List<String> denormalizeColumns = new ArrayList<String>();
        List<String> denormalizeColumnsType = new ArrayList<String>();
        List<String> denormalizeDelimiters = new ArrayList<String>();
        List<Boolean> denormalizeMergeFlags = new ArrayList<Boolean>();
        List<IMetadataColumn> groupColumns = new ArrayList<IMetadataColumn>();
        for(Map<String, String> denormalize : denormalizes){
        	String columnName = denormalize.get("INPUT_COLUMN");
        	if(denormalizeColumns.contains(columnName)){
        		continue;
        	}
        	denormalizeColumns.add(columnName);
        	denormalizeColumnsType.add(typesMap.get(columnName));
        	denormalizeDelimiters.add(denormalize.get("DELIMITER"));
        	denormalizeMergeFlags.add(("true").equals(denormalize.get("MERGE")));
        }
        for(IMetadataColumn column : columns){
        	String columnName = column.getLabel();
        	if(denormalizeColumns.contains(columnName)){
        		continue;
        	}
        	groupColumns.add(column);
        }
        

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if(groupColumns.size() > 0){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	for(IMetadataColumn column : groupColumns){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    	}
	for(int i = 0; i < denormalizeColumns.size(); i++){
		String columnName = denormalizeColumns.get(i);
		String columnType = denormalizeColumnsType.get(i);
		if(denormalizeMergeFlags.get(i)){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_16);
    
		}else{
			if((("java.util.Date").equals(columnType)) && (patternsMap.get(columnName).length() != 0)){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(patternsMap.get(columnName) );
    stringBuffer.append(TEXT_19);
    
			}else{

    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_16);
    
			}
		}
	}

    stringBuffer.append(TEXT_21);
    
if(groupColumns.size() > 0){//while loop

    stringBuffer.append(TEXT_22);
    	for(int i = 0; i < groupColumns.size(); i++){
		String columnName = groupColumns.get(i).getLabel();
		if(!JavaTypesManager.isJavaPrimitiveType(groupColumns.get(i).getTalendType(),groupColumns.get(i).isNullable())){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    		}else{

    stringBuffer.append(TEXT_23);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    		}
		if(i+1 == groupColumns.size()){

    stringBuffer.append(TEXT_34);
    		}
	}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
}//while loop end

    
	for(int i = 0; i < denormalizeColumns.size(); i++){
		String columnName = denormalizeColumns.get(i);
		String columnType = denormalizeColumnsType.get(i);
		if(denormalizeMergeFlags.get(i)){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_40);
    
		}else{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(denormalizeDelimiters.get(i) );
    stringBuffer.append(TEXT_16);
    
			if((("java.util.Date").equals(columnType)) && (patternsMap.get(columnName).length() != 0)){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(patternsMap.get(columnName) );
    stringBuffer.append(TEXT_19);
    
			}else{

    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_16);
    
			}
		}
	}

if(groupColumns.size() > 0){

    stringBuffer.append(TEXT_42);
    
}

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    

if(groupColumns.size() > 0){
	//??

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
	//do out start ...
	conns = null;
	conns = node.getOutgoingSortedConnections();
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
				for(IMetadataColumn column : groupColumns){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
				}
				
				for(int i = 0; i < denormalizeColumns.size(); i++){
					String columnName = denormalizeColumns.get(i);
					String columnType = denormalizeColumnsType.get(i);
					if(denormalizeMergeFlags.get(i)){

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(typesMap.get(columnName) );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(denormalizeDelimiters.get(i) );
    stringBuffer.append(TEXT_58);
    
						if((("java.util.Date").equals(columnType)) && (patternsMap.get(columnName).length() != 0)){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(patternsMap.get(columnName) );
    stringBuffer.append(TEXT_19);
    
						}else{

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
						}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    
					}else{

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
					}
				}
			}
		}
	}
	//do out end ...
	
	
	//do first
	for(IMetadataColumn column : groupColumns){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    	}
	for(int i = 0; i < denormalizeColumns.size(); i++){
		String columnName = denormalizeColumns.get(i);
		String columnType = denormalizeColumnsType.get(i);
		if(denormalizeMergeFlags.get(i)){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_16);
    
		}else{
			if((("java.util.Date").equals(columnType)) && (patternsMap.get(columnName).length() != 0)){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(patternsMap.get(columnName) );
    stringBuffer.append(TEXT_19);
    
			}else{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_16);
    
			}
		}
	}

    stringBuffer.append(TEXT_70);
    
}
/////////////////////////////////////////////////

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(rowCount );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
	//do out start ...
	conns = null;
	conns = node.getOutgoingSortedConnections();
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
				for(IMetadataColumn column : groupColumns){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
				}
				
				for(int i = 0; i < denormalizeColumns.size(); i++){
					String columnName = denormalizeColumns.get(i);
					String columnType = denormalizeColumnsType.get(i);
					if(denormalizeMergeFlags.get(i)){

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(typesMap.get(columnName) );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(denormalizeDelimiters.get(i) );
    stringBuffer.append(TEXT_58);
    
						if((("java.util.Date").equals(columnType)) && (patternsMap.get(columnName).length() != 0)){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(patternsMap.get(columnName) );
    stringBuffer.append(TEXT_19);
    
						}else{

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
						}

    stringBuffer.append(TEXT_74);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    
					}else{

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
					}
				}
			}
		}
	}
	//do out end ...


    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
conns = null;
conns = node.getOutgoingSortedConnections();
if (conns!=null) {
	for (int i=0;i<conns.size();i++) {
		IConnection conn = conns.get(i);
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_82);
    			}
		}
	}
}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	}
	}
}

    stringBuffer.append(TEXT_84);
    return stringBuffer.toString();
  }
}
