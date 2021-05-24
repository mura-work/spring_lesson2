package com.example.demo.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ java.lang.annotation.ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { EmployeeValidator.class })
public @interface Employee {
	String message() default "入力エラーが発生しました";	// デフォルトのメッセージ
	Class<?>[] groups() default {};	// 対象の入力チェックを特定のグループに分類化する、値を指定しないとデフォルト{}になる
	Class<? extends Payload>[] payload() default {};	// 任意のカテゴリを付与する	
//	String fieldEmpId() default "empId";
	String fieldEmpPass() default "empPass";
	String fieldEmpName() default "empName";
//	String fieldGender() default "gender";
	String fieldAddress() default "address";
	String fieldBirthday() default "birthday";
//	String fieldAuthority() default "authority";
//	String fieldDeptId() default "deptId";
}
