/*
 *  Copyright 2019-2020 Wensen Ma
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.wensenma.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Wensen Ma
 * @date 2019-6-4 13:52:30
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {

    // 基本对象的属性名
    String propName() default "";
    // 查询方式
    Type type() default Type.EQUAL;

    /**
     * 连接查询的属性名，如User类中的dept
     */
    String joinName() default "";

    /**
     * 默认左连接
     */
    Join join() default Join.LEFT;

    /**
     * 多字段模糊搜索，仅支持String类型字段，多个用逗号隔开, 如@Query(blurry = "email,username")
     */
    String blurry() default "";

    enum Type {
        // 相等
        EQUAL
        // 大于等于
        , GREATER_THAN
        // 小于等于
        , LESS_THAN
        // 中模糊查询
        , INNER_LIKE
        // 左模糊查询
        , LEFT_LIKE
        // 右模糊查询
        , RIGHT_LIKE
        // 小于
        , LESS_THAN_NQ
        // 包含
        , IN
        // 不等于
        ,NOT_EQUAL
        // between
        ,BETWEEN
        // 不为空
        ,NOT_NULL
        // 为空
        ,IS_NULL
    }

    /**
     * @author Wensen Ma
     * 适用于简单连接查询，复杂的请自定义该注解，或者使用sql查询
     */
    enum Join {
        /** 2019-6-4 13:18:30 */
        LEFT, RIGHT, INNER
    }

}

