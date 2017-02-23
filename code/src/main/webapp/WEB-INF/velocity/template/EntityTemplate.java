package ${classInfo.basePackageName}.entity;

#if(${classInfo.hasDate})
import java.util.Date;
#end

public class ${classInfo.className} {

#foreach($column in ${classInfo.columns})
	private ${column.dataType} ${column.columnName};${column.columnComment}
#end

#foreach($column in ${classInfo.columns})
	public void set${column.firstLetterUpperColumnName}(${column.dataType} ${column.columnName}) {
		this.${column.columnName} = ${column.columnName};
	}
	
#end
#foreach($column in ${classInfo.columns})
	public ${column.dataType} get${column.firstLetterUpperColumnName}() {
		return ${column.columnName};
	}
	
#end
}