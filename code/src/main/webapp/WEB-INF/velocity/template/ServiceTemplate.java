package ${classInfo.basePackageName}.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${classInfo.basePackageName}.dao.${classInfo.className}Service;
import ${classInfo.basePackageName}.entity.${classInfo.className};

@Service
public class ${classInfo.className}ServiceImpl implements ${classInfo.className}Service {
	@Autowired
	private ${classInfo.className}Service ${classInfo.firstLetterLowerClassName}Service;

	@Override
	public ${classInfo.className} get${classInfo.className}ById(${classInfo.primaryKey.dataType} ${classInfo.primaryKey.columnName}) {
		return ${classInfo.firstLetterLowerClassName}Service.get${classInfo.className}ById(${classInfo.primaryKey.columnName});
	}

	@Override
	public List<${classInfo.className}> list${classInfo.className}(${classInfo.className} t) {
		return ${classInfo.firstLetterLowerClassName}Service.list${classInfo.className}(t);
	}

	@Override
	public int save${classInfo.className}(${classInfo.className} t) {
		return ${classInfo.firstLetterLowerClassName}Service.save${classInfo.className}(t);
	}

	@Override
	public int remove${classInfo.className}(${classInfo.primaryKey.dataType} ${classInfo.primaryKey.columnName}) {
		return ${classInfo.firstLetterLowerClassName}Service.remove${classInfo.className}(${classInfo.primaryKey.columnName});
	}

	@Override
	public int update${classInfo.className}(${classInfo.className} t) {
		return ${classInfo.firstLetterLowerClassName}Service.update${classInfo.className}(t);
	}

}