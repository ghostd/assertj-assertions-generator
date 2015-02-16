/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2014 the original author or authors.
 */
package org.assertj.assertions.generator.description;

import static org.assertj.assertions.generator.util.ClassUtil.getNegativePredicateFor;

/**
 * base class to describe a field or a property/getter
 */
public abstract class DataDescription {

  private final String name;
  protected final String originalMember;
  protected final TypeDescription typeDescription;

  public DataDescription(String name, String originalMember, TypeDescription typeDescription) {
	super();
	this.name = name;
	this.originalMember = originalMember;
	this.typeDescription = typeDescription;
  }

  public String getName() {
	return name;
  }

  public String getOriginalMember() {
	return originalMember;
  }

  public TypeDescription getTypeDescription() {
	return typeDescription;
  }
  
  public String getTypeName() {
	return typeDescription.getSimpleNameWithOuterClass();
  }

  public boolean isIterableType() {
	return typeDescription.isIterable();
  }

  public boolean isArrayType() {
	return typeDescription.isArray();
  }

  public boolean isPrimitiveType() {
	return typeDescription.isPrimitive();
  }

  public boolean isRealNumberType() {
	return typeDescription.isRealNumber();
  }

  public abstract boolean isPredicate();

  public String getPredicate() {
	return originalMember;
  }
  
  public String getNegativePredicate() {
	return getNegativePredicateFor(originalMember);
  }
  
  /**
   * return the simple element type name if element type belongs to given the package and the fully qualified element
   * type name otherwise.
   * 
   * @param packageName typically the package of the enclosing Class
   * @return the simple element type name if element type belongs to given the package and the fully qualified element
   * type name otherwise.
   */
  public String getElementTypeName(String packageName) {
	return typeDescription.getElementTypeName() == null ? null
	    : typeDescription.getElementTypeName().getFullyQualifiedTypeNameIfNeeded(packageName);
  }

  public String getFullyQualifiedTypeNameIfNeeded(String packageName) {
	return typeDescription.getFullyQualifiedTypeNameIfNeeded(packageName);
  }

}