package ${classInfo.basePackageName}.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ${classInfo.basePackageName}.entity.${classInfo.className};

@Repository
public interface ${classInfo.className}Service {

	${classInfo.className} get${classInfo.className}ById(${classInfo.primaryKey.dataType} ${classInfo.primaryKey.columnName});

	List<${classInfo.className}> list${classInfo.className}(${classInfo.className} t);

	int save${classInfo.className}(${classInfo.className} t);

	int remove${classInfo.className}(${classInfo.primaryKey.dataType} ${classInfo.primaryKey.columnName});

	int update${classInfo.className}(${classInfo.className} t);
}