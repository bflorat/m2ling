/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://m2ling.org/core/0.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "m2ling_core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CorePackage eINSTANCE = org.m2ling.domain.core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasCustomPropertiesImpl <em>Has Custom Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasCustomPropertiesImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasCustomProperties()
	 * @generated
	 */
	int HAS_CUSTOM_PROPERTIES = 13;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ConceptItemImpl <em>Concept Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ConceptItemImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getConceptItem()
	 * @generated
	 */
	int CONCEPT_ITEM = 8;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ComponentTypeImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasNameAndIDImpl <em>Has Name And ID</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasNameAndIDImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasNameAndID()
	 * @generated
	 */
	int HAS_NAME_AND_ID = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NAME_AND_ID__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NAME_AND_ID__NAME = 1;

	/**
	 * The number of structural features of the '<em>Has Name And ID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NAME_AND_ID_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM__ID = HAS_NAME_AND_ID__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM__NAME = HAS_NAME_AND_ID__NAME;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM__CUSTOM_PROPERTIES = HAS_NAME_AND_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM__COMMENT = HAS_NAME_AND_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM__TAGS = HAS_NAME_AND_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM__LABEL = HAS_NAME_AND_ID_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Concept Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM_FEATURE_COUNT = HAS_NAME_AND_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__ID = CONCEPT_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__NAME = CONCEPT_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__CUSTOM_PROPERTIES = CONCEPT_ITEM__CUSTOM_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__COMMENT = CONCEPT_ITEM__COMMENT;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__TAGS = CONCEPT_ITEM__TAGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__LABEL = CONCEPT_ITEM__LABEL;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__SUB_TYPES = CONCEPT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binded Component Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__BINDED_COMPONENT_TYPE = CONCEPT_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Engine Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__ENGINE_TYPE = CONCEPT_ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_FEATURE_COUNT = CONCEPT_ITEM_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ArchitectureItemImpl <em>Architecture Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ArchitectureItemImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getArchitectureItem()
	 * @generated
	 */
	int ARCHITECTURE_ITEM = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ITEM__ID = HAS_NAME_AND_ID__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ITEM__NAME = HAS_NAME_AND_ID__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ITEM__COMMENT = HAS_NAME_AND_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ITEM__TAGS = HAS_NAME_AND_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ITEM__LABEL = HAS_NAME_AND_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Architecture Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ITEM_FEATURE_COUNT = HAS_NAME_AND_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ComponentGroupImpl <em>Component Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ComponentGroupImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentGroup()
	 * @generated
	 */
	int COMPONENT_GROUP = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_GROUP__ID = ARCHITECTURE_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_GROUP__NAME = ARCHITECTURE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_GROUP__COMMENT = ARCHITECTURE_ITEM__COMMENT;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_GROUP__TAGS = ARCHITECTURE_ITEM__TAGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_GROUP__LABEL = ARCHITECTURE_ITEM__LABEL;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_GROUP__COMPONENTS = ARCHITECTURE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_GROUP_FEATURE_COUNT = ARCHITECTURE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ComponentImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ID = COMPONENT_GROUP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = COMPONENT_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__COMMENT = COMPONENT_GROUP__COMMENT;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__TAGS = COMPONENT_GROUP__TAGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__LABEL = COMPONENT_GROUP__LABEL;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__COMPONENTS = COMPONENT_GROUP__COMPONENTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__TYPE = COMPONENT_GROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SUB_COMPONENTS = COMPONENT_GROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ENGINE = COMPONENT_GROUP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = COMPONENT_GROUP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.RuntimeItemImpl <em>Runtime Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.RuntimeItemImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRuntimeItem()
	 * @generated
	 */
	int RUNTIME_ITEM = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_ITEM__ID = HAS_NAME_AND_ID__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_ITEM__NAME = HAS_NAME_AND_ID__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_ITEM__COMMENT = HAS_NAME_AND_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_ITEM__TAGS = HAS_NAME_AND_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_ITEM__LABEL = HAS_NAME_AND_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Runtime Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_ITEM_FEATURE_COUNT = HAS_NAME_AND_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ComponentNodeGroupImpl <em>Component Node Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ComponentNodeGroupImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentNodeGroup()
	 * @generated
	 */
	int COMPONENT_NODE_GROUP = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_GROUP__ID = RUNTIME_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_GROUP__NAME = RUNTIME_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_GROUP__COMMENT = RUNTIME_ITEM__COMMENT;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_GROUP__TAGS = RUNTIME_ITEM__TAGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_GROUP__LABEL = RUNTIME_ITEM__LABEL;

	/**
	 * The feature id for the '<em><b>Component Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_GROUP__COMPONENT_NODES = RUNTIME_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Node Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_GROUP_FEATURE_COUNT = RUNTIME_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ComponentNodeImpl <em>Component Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ComponentNodeImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentNode()
	 * @generated
	 */
	int COMPONENT_NODE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__ID = COMPONENT_NODE_GROUP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__NAME = COMPONENT_NODE_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__COMMENT = COMPONENT_NODE_GROUP__COMMENT;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__TAGS = COMPONENT_NODE_GROUP__TAGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__LABEL = COMPONENT_NODE_GROUP__LABEL;

	/**
	 * The feature id for the '<em><b>Component Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__COMPONENT_NODES = COMPONENT_NODE_GROUP__COMPONENT_NODES;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__COMPONENT = COMPONENT_NODE_GROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__SUB_NODES = COMPONENT_NODE_GROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__ENGINE = COMPONENT_NODE_GROUP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_FEATURE_COUNT = COMPONENT_NODE_GROUP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ViewPointImpl <em>View Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ViewPointImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getViewPoint()
	 * @generated
	 */
	int VIEW_POINT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__ID = CONCEPT_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__NAME = CONCEPT_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__CUSTOM_PROPERTIES = CONCEPT_ITEM__CUSTOM_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__COMMENT = CONCEPT_ITEM__COMMENT;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__TAGS = CONCEPT_ITEM__TAGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__LABEL = CONCEPT_ITEM__LABEL;

	/**
	 * The feature id for the '<em><b>Base Viewpoint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__BASE_VIEWPOINT = CONCEPT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__ACTIVITIES = CONCEPT_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__COMPONENT_TYPES = CONCEPT_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Link Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__LINK_TYPES = CONCEPT_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__RULES = CONCEPT_ITEM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>View Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT_FEATURE_COUNT = CONCEPT_ITEM_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ViewImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getView()
	 * @generated
	 */
	int VIEW = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ID = ARCHITECTURE_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NAME = ARCHITECTURE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__COMMENT = ARCHITECTURE_ITEM__COMMENT;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__TAGS = ARCHITECTURE_ITEM__TAGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__LABEL = ARCHITECTURE_ITEM__LABEL;

	/**
	 * The feature id for the '<em><b>Components Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__COMPONENTS_GROUPS = ARCHITECTURE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__COMPONENTS = ARCHITECTURE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>View Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__VIEW_POINT = ARCHITECTURE_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__LINKS = ARCHITECTURE_ITEM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = ARCHITECTURE_ITEM_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasTagsImpl <em>Has Tags</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasTagsImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasTags()
	 * @generated
	 */
	int HAS_TAGS = 11;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_TAGS__TAGS = 0;

	/**
	 * The number of structural features of the '<em>Has Tags</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_TAGS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasCommentImpl <em>Has Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasCommentImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasComment()
	 * @generated
	 */
	int HAS_COMMENT = 12;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_COMMENT__COMMENT = 0;

	/**
	 * The number of structural features of the '<em>Has Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_COMMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES = 0;

	/**
	 * The number of structural features of the '<em>Has Custom Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_CUSTOM_PROPERTIES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.CustomPropertyImpl <em>Custom Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.CustomPropertyImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getCustomProperty()
	 * @generated
	 */
	int CUSTOM_PROPERTY = 14;

	/**
	 * The number of structural features of the '<em>Custom Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.LinkTypeImpl <em>Link Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.LinkTypeImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getLinkType()
	 * @generated
	 */
	int LINK_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__ID = CONCEPT_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__NAME = CONCEPT_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__CUSTOM_PROPERTIES = CONCEPT_ITEM__CUSTOM_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__COMMENT = CONCEPT_ITEM__COMMENT;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__TAGS = CONCEPT_ITEM__TAGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__LABEL = CONCEPT_ITEM__LABEL;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__SOURCE_TYPE = CONCEPT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__DESTINATION_TYPE = CONCEPT_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE_FEATURE_COUNT = CONCEPT_ITEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.LinkImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getLink()
	 * @generated
	 */
	int LINK = 16;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__COMMENT = HAS_COMMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__CUSTOM_PROPERTIES = HAS_COMMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__ID = HAS_COMMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__NAME = HAS_COMMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TAGS = HAS_COMMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TYPE = HAS_COMMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SOURCE = HAS_COMMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__DESTINATION = HAS_COMMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = HAS_COMMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.StreamImpl <em>Stream</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.StreamImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getStream()
	 * @generated
	 */
	int STREAM = 17;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Stream</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasParameterDefinitionsImpl <em>Has Parameter Definitions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasParameterDefinitionsImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasParameterDefinitions()
	 * @generated
	 */
	int HAS_PARAMETER_DEFINITIONS = 18;

	/**
	 * The number of structural features of the '<em>Has Parameter Definitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_PARAMETER_DEFINITIONS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasParameterValuesImpl <em>Has Parameter Values</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasParameterValuesImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasParameterValues()
	 * @generated
	 */
	int HAS_PARAMETER_VALUES = 19;

	/**
	 * The number of structural features of the '<em>Has Parameter Values</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_PARAMETER_VALUES_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.StakeholderImpl <em>Stakeholder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.StakeholderImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getStakeholder()
	 * @generated
	 */
	int STAKEHOLDER = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__ID = HAS_NAME_AND_ID__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__NAME = HAS_NAME_AND_ID__NAME;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__LABEL = HAS_NAME_AND_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__VIEWS = HAS_NAME_AND_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>View Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__VIEW_POINTS = HAS_NAME_AND_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__ACTORS = HAS_NAME_AND_ID_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Stakeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_FEATURE_COUNT = HAS_NAME_AND_ID_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 21;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.FloatConstraintImpl <em>Float Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.FloatConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getFloatConstraint()
	 * @generated
	 */
	int FLOAT_CONSTRAINT = 22;

	/**
	 * The number of structural features of the '<em>Float Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.BoundaryConstraintImpl <em>Boundary Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.BoundaryConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getBoundaryConstraint()
	 * @generated
	 */
	int BOUNDARY_CONSTRAINT = 24;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_CONSTRAINT__VALUE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_CONSTRAINT__INCLUSIVE = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boundary Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.MinConstraintImpl <em>Min Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.MinConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getMinConstraint()
	 * @generated
	 */
	int MIN_CONSTRAINT = 23;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_CONSTRAINT__VALUE = BOUNDARY_CONSTRAINT__VALUE;

	/**
	 * The feature id for the '<em><b>Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_CONSTRAINT__INCLUSIVE = BOUNDARY_CONSTRAINT__INCLUSIVE;

	/**
	 * The number of structural features of the '<em>Min Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_CONSTRAINT_FEATURE_COUNT = BOUNDARY_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.URLConstraintImpl <em>URL Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.URLConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getURLConstraint()
	 * @generated
	 */
	int URL_CONSTRAINT = 25;

	/**
	 * The number of structural features of the '<em>URL Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.NotNullConstraintImpl <em>Not Null Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.NotNullConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getNotNullConstraint()
	 * @generated
	 */
	int NOT_NULL_CONSTRAINT = 26;

	/**
	 * The number of structural features of the '<em>Not Null Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_NULL_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.RegexpConstraintImpl <em>Regexp Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.RegexpConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRegexpConstraint()
	 * @generated
	 */
	int REGEXP_CONSTRAINT = 27;

	/**
	 * The feature id for the '<em><b>Regexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEXP_CONSTRAINT__REGEXP = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Regexp Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEXP_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.OCLConstraintImpl <em>OCL Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.OCLConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getOCLConstraint()
	 * @generated
	 */
	int OCL_CONSTRAINT = 28;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__EXPRESSION = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OCL Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.IntegerConstraintImpl <em>Integer Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.IntegerConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getIntegerConstraint()
	 * @generated
	 */
	int INTEGER_CONSTRAINT = 29;

	/**
	 * The number of structural features of the '<em>Integer Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.MaxConstraintImpl <em>Max Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.MaxConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getMaxConstraint()
	 * @generated
	 */
	int MAX_CONSTRAINT = 30;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_CONSTRAINT__VALUE = BOUNDARY_CONSTRAINT__VALUE;

	/**
	 * The feature id for the '<em><b>Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_CONSTRAINT__INCLUSIVE = BOUNDARY_CONSTRAINT__INCLUSIVE;

	/**
	 * The number of structural features of the '<em>Max Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_CONSTRAINT_FEATURE_COUNT = BOUNDARY_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.EMailConstraintImpl <em>EMail Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.EMailConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEMailConstraint()
	 * @generated
	 */
	int EMAIL_CONSTRAINT = 31;

	/**
	 * The number of structural features of the '<em>EMail Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.FormatConstraintImpl <em>Format Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.FormatConstraintImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getFormatConstraint()
	 * @generated
	 */
	int FORMAT_CONSTRAINT = 32;

	/**
	 * The number of structural features of the '<em>Format Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasConstraintsImpl <em>Has Constraints</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasConstraintsImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasConstraints()
	 * @generated
	 */
	int HAS_CONSTRAINTS = 33;

	/**
	 * The number of structural features of the '<em>Has Constraints</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_CONSTRAINTS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ActivityImpl <em>Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ActivityImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getActivity()
	 * @generated
	 */
	int ACTIVITY = 34;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__ID = HAS_NAME_AND_ID__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__NAME = HAS_NAME_AND_ID__NAME;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__TAGS = HAS_NAME_AND_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__LABEL = HAS_NAME_AND_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Accountables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__ACCOUNTABLES = HAS_NAME_AND_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Responsibles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__RESPONSIBLES = HAS_NAME_AND_ID_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FEATURE_COUNT = HAS_NAME_AND_ID_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ActivityTransitionImpl <em>Activity Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ActivityTransitionImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getActivityTransition()
	 * @generated
	 */
	int ACTIVITY_TRANSITION = 35;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TRANSITION__COMMENT = HAS_COMMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TRANSITION__LABEL = HAS_COMMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TRANSITION__DATE = HAS_COMMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>From Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TRANSITION__FROM_STATUS = HAS_COMMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>To Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TRANSITION__TO_STATUS = HAS_COMMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TRANSITION__ACTIVITY = HAS_COMMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TRANSITION__ACTOR = HAS_COMMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Activity Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TRANSITION_FEATURE_COUNT = HAS_COMMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.OrganisationalUnitImpl <em>Organisational Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.OrganisationalUnitImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getOrganisationalUnit()
	 * @generated
	 */
	int ORGANISATIONAL_UNIT = 36;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANISATIONAL_UNIT__COMMENT = HAS_COMMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANISATIONAL_UNIT__CUSTOM_PROPERTIES = HAS_COMMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANISATIONAL_UNIT__ID = HAS_COMMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANISATIONAL_UNIT__NAME = HAS_COMMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANISATIONAL_UNIT__TAGS = HAS_COMMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANISATIONAL_UNIT__LABEL = HAS_COMMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Organisational Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANISATIONAL_UNIT_FEATURE_COUNT = HAS_COMMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ActorImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 37;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__CUSTOM_PROPERTIES = HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__TAGS = HAS_CUSTOM_PROPERTIES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__LABEL = HAS_CUSTOM_PROPERTIES_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__STAKEHOLDERS = HAS_CUSTOM_PROPERTIES_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__UNIT = HAS_CUSTOM_PROPERTIES_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__USERNAME = HAS_CUSTOM_PROPERTIES_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Admin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ADMIN = HAS_CUSTOM_PROPERTIES_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Pwd Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PWD_HASH = HAS_CUSTOM_PROPERTIES_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__FIRST_NAME = HAS_CUSTOM_PROPERTIES_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__LAST_NAME = HAS_CUSTOM_PROPERTIES_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = HAS_CUSTOM_PROPERTIES_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.RuleImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRule()
	 * @generated
	 */
	int RULE = 38;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ID = CONCEPT_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = CONCEPT_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__CUSTOM_PROPERTIES = CONCEPT_ITEM__CUSTOM_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__COMMENT = CONCEPT_ITEM__COMMENT;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__TAGS = CONCEPT_ITEM__TAGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__LABEL = CONCEPT_ITEM__LABEL;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__STATUS = CONCEPT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__PRIORITY = CONCEPT_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = CONCEPT_ITEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasLabelImpl <em>Has Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasLabelImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasLabel()
	 * @generated
	 */
	int HAS_LABEL = 39;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_LABEL__LABEL = 0;

	/**
	 * The number of structural features of the '<em>Has Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_LABEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.CustomPropertyType <em>Custom Property Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.CustomPropertyType
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getCustomPropertyType()
	 * @generated
	 */
	int CUSTOM_PROPERTY_TYPE = 40;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.ActivityStatus <em>Activity Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.ActivityStatus
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getActivityStatus()
	 * @generated
	 */
	int ACTIVITY_STATUS = 41;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.Type
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getType()
	 * @generated
	 */
	int TYPE = 42;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.RuleStatus <em>Rule Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.RuleStatus
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRuleStatus()
	 * @generated
	 */
	int RULE_STATUS = 43;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.RulePriority <em>Rule Priority</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.RulePriority
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRulePriority()
	 * @generated
	 */
	int RULE_PRIORITY = 44;


	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.m2ling.domain.core.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.ComponentType#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Types</em>'.
	 * @see org.m2ling.domain.core.ComponentType#getSubTypes()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_SubTypes();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.ComponentType#getBindedComponentType <em>Binded Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binded Component Type</em>'.
	 * @see org.m2ling.domain.core.ComponentType#getBindedComponentType()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_BindedComponentType();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.ComponentType#getEngineType <em>Engine Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Engine Type</em>'.
	 * @see org.m2ling.domain.core.ComponentType#getEngineType()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_EngineType();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.m2ling.domain.core.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.Component#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.m2ling.domain.core.Component#getType()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.Component#getSubComponents <em>Sub Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Components</em>'.
	 * @see org.m2ling.domain.core.Component#getSubComponents()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_SubComponents();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.Component#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Engine</em>'.
	 * @see org.m2ling.domain.core.Component#getEngine()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Engine();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.HasNameAndID <em>Has Name And ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Name And ID</em>'.
	 * @see org.m2ling.domain.core.HasNameAndID
	 * @generated
	 */
	EClass getHasNameAndID();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.HasNameAndID#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.m2ling.domain.core.HasNameAndID#getId()
	 * @see #getHasNameAndID()
	 * @generated
	 */
	EAttribute getHasNameAndID_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.HasNameAndID#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.m2ling.domain.core.HasNameAndID#getName()
	 * @see #getHasNameAndID()
	 * @generated
	 */
	EAttribute getHasNameAndID_Name();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.ComponentNode <em>Component Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Node</em>'.
	 * @see org.m2ling.domain.core.ComponentNode
	 * @generated
	 */
	EClass getComponentNode();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.ComponentNode#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see org.m2ling.domain.core.ComponentNode#getComponent()
	 * @see #getComponentNode()
	 * @generated
	 */
	EReference getComponentNode_Component();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.ComponentNode#getSubNodes <em>Sub Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Nodes</em>'.
	 * @see org.m2ling.domain.core.ComponentNode#getSubNodes()
	 * @see #getComponentNode()
	 * @generated
	 */
	EReference getComponentNode_SubNodes();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.ComponentNode#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Engine</em>'.
	 * @see org.m2ling.domain.core.ComponentNode#getEngine()
	 * @see #getComponentNode()
	 * @generated
	 */
	EReference getComponentNode_Engine();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.ViewPoint <em>View Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Point</em>'.
	 * @see org.m2ling.domain.core.ViewPoint
	 * @generated
	 */
	EClass getViewPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.ViewPoint#getComponentTypes <em>Component Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Types</em>'.
	 * @see org.m2ling.domain.core.ViewPoint#getComponentTypes()
	 * @see #getViewPoint()
	 * @generated
	 */
	EReference getViewPoint_ComponentTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.ViewPoint#getActivities <em>Activities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Activities</em>'.
	 * @see org.m2ling.domain.core.ViewPoint#getActivities()
	 * @see #getViewPoint()
	 * @generated
	 */
	EReference getViewPoint_Activities();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.ViewPoint#getBaseViewpoint <em>Base Viewpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Viewpoint</em>'.
	 * @see org.m2ling.domain.core.ViewPoint#getBaseViewpoint()
	 * @see #getViewPoint()
	 * @generated
	 */
	EReference getViewPoint_BaseViewpoint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.ViewPoint#getLinkTypes <em>Link Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link Types</em>'.
	 * @see org.m2ling.domain.core.ViewPoint#getLinkTypes()
	 * @see #getViewPoint()
	 * @generated
	 */
	EReference getViewPoint_LinkTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.ViewPoint#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.m2ling.domain.core.ViewPoint#getRules()
	 * @see #getViewPoint()
	 * @generated
	 */
	EReference getViewPoint_Rules();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.ComponentGroup <em>Component Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Group</em>'.
	 * @see org.m2ling.domain.core.ComponentGroup
	 * @generated
	 */
	EClass getComponentGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.ComponentGroup#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Components</em>'.
	 * @see org.m2ling.domain.core.ComponentGroup#getComponents()
	 * @see #getComponentGroup()
	 * @generated
	 */
	EReference getComponentGroup_Components();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.ComponentNodeGroup <em>Component Node Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Node Group</em>'.
	 * @see org.m2ling.domain.core.ComponentNodeGroup
	 * @generated
	 */
	EClass getComponentNodeGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.ComponentNodeGroup#getComponentNodes <em>Component Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Component Nodes</em>'.
	 * @see org.m2ling.domain.core.ComponentNodeGroup#getComponentNodes()
	 * @see #getComponentNodeGroup()
	 * @generated
	 */
	EReference getComponentNodeGroup_ComponentNodes();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.ArchitectureItem <em>Architecture Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Item</em>'.
	 * @see org.m2ling.domain.core.ArchitectureItem
	 * @generated
	 */
	EClass getArchitectureItem();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.ConceptItem <em>Concept Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept Item</em>'.
	 * @see org.m2ling.domain.core.ConceptItem
	 * @generated
	 */
	EClass getConceptItem();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.RuntimeItem <em>Runtime Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime Item</em>'.
	 * @see org.m2ling.domain.core.RuntimeItem
	 * @generated
	 */
	EClass getRuntimeItem();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see org.m2ling.domain.core.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.View#getComponentsGroups <em>Components Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components Groups</em>'.
	 * @see org.m2ling.domain.core.View#getComponentsGroups()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_ComponentsGroups();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.View#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see org.m2ling.domain.core.View#getComponents()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Components();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.View#getViewPoint <em>View Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>View Point</em>'.
	 * @see org.m2ling.domain.core.View#getViewPoint()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_ViewPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.View#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.m2ling.domain.core.View#getLinks()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Links();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.HasTags <em>Has Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Tags</em>'.
	 * @see org.m2ling.domain.core.HasTags
	 * @generated
	 */
	EClass getHasTags();

	/**
	 * Returns the meta object for the attribute list '{@link org.m2ling.domain.core.HasTags#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tags</em>'.
	 * @see org.m2ling.domain.core.HasTags#getTags()
	 * @see #getHasTags()
	 * @generated
	 */
	EAttribute getHasTags_Tags();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.HasComment <em>Has Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Comment</em>'.
	 * @see org.m2ling.domain.core.HasComment
	 * @generated
	 */
	EClass getHasComment();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.HasComment#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.m2ling.domain.core.HasComment#getComment()
	 * @see #getHasComment()
	 * @generated
	 */
	EAttribute getHasComment_Comment();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.HasCustomProperties <em>Has Custom Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Custom Properties</em>'.
	 * @see org.m2ling.domain.core.HasCustomProperties
	 * @generated
	 */
	EClass getHasCustomProperties();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.HasCustomProperties#getCustomProperties <em>Custom Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Custom Properties</em>'.
	 * @see org.m2ling.domain.core.HasCustomProperties#getCustomProperties()
	 * @see #getHasCustomProperties()
	 * @generated
	 */
	EReference getHasCustomProperties_CustomProperties();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.CustomProperty <em>Custom Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Property</em>'.
	 * @see org.m2ling.domain.core.CustomProperty
	 * @generated
	 */
	EClass getCustomProperty();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.LinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Type</em>'.
	 * @see org.m2ling.domain.core.LinkType
	 * @generated
	 */
	EClass getLinkType();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.LinkType#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Type</em>'.
	 * @see org.m2ling.domain.core.LinkType#getSourceType()
	 * @see #getLinkType()
	 * @generated
	 */
	EReference getLinkType_SourceType();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.LinkType#getDestinationType <em>Destination Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination Type</em>'.
	 * @see org.m2ling.domain.core.LinkType#getDestinationType()
	 * @see #getLinkType()
	 * @generated
	 */
	EReference getLinkType_DestinationType();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.m2ling.domain.core.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.Link#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.m2ling.domain.core.Link#getType()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Type();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.Link#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.m2ling.domain.core.Link#getSource()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Source();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.Link#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.m2ling.domain.core.Link#getDestination()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Destination();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Stream <em>Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream</em>'.
	 * @see org.m2ling.domain.core.Stream
	 * @generated
	 */
	EClass getStream();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.Stream#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.m2ling.domain.core.Stream#getSource()
	 * @see #getStream()
	 * @generated
	 */
	EReference getStream_Source();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.Stream#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.m2ling.domain.core.Stream#getDestination()
	 * @see #getStream()
	 * @generated
	 */
	EReference getStream_Destination();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.Stream#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.m2ling.domain.core.Stream#getType()
	 * @see #getStream()
	 * @generated
	 */
	EReference getStream_Type();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.HasParameterDefinitions <em>Has Parameter Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Parameter Definitions</em>'.
	 * @see org.m2ling.domain.core.HasParameterDefinitions
	 * @generated
	 */
	EClass getHasParameterDefinitions();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.HasParameterValues <em>Has Parameter Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Parameter Values</em>'.
	 * @see org.m2ling.domain.core.HasParameterValues
	 * @generated
	 */
	EClass getHasParameterValues();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Stakeholder <em>Stakeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stakeholder</em>'.
	 * @see org.m2ling.domain.core.Stakeholder
	 * @generated
	 */
	EClass getStakeholder();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Stakeholder#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Views</em>'.
	 * @see org.m2ling.domain.core.Stakeholder#getViews()
	 * @see #getStakeholder()
	 * @generated
	 */
	EReference getStakeholder_Views();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Stakeholder#getViewPoints <em>View Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>View Points</em>'.
	 * @see org.m2ling.domain.core.Stakeholder#getViewPoints()
	 * @see #getStakeholder()
	 * @generated
	 */
	EReference getStakeholder_ViewPoints();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Stakeholder#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see org.m2ling.domain.core.Stakeholder#getActors()
	 * @see #getStakeholder()
	 * @generated
	 */
	EReference getStakeholder_Actors();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.m2ling.domain.core.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.FloatConstraint <em>Float Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float Constraint</em>'.
	 * @see org.m2ling.domain.core.FloatConstraint
	 * @generated
	 */
	EClass getFloatConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.MinConstraint <em>Min Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Constraint</em>'.
	 * @see org.m2ling.domain.core.MinConstraint
	 * @generated
	 */
	EClass getMinConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.BoundaryConstraint <em>Boundary Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boundary Constraint</em>'.
	 * @see org.m2ling.domain.core.BoundaryConstraint
	 * @generated
	 */
	EClass getBoundaryConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.BoundaryConstraint#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.m2ling.domain.core.BoundaryConstraint#getValue()
	 * @see #getBoundaryConstraint()
	 * @generated
	 */
	EAttribute getBoundaryConstraint_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.BoundaryConstraint#isInclusive <em>Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inclusive</em>'.
	 * @see org.m2ling.domain.core.BoundaryConstraint#isInclusive()
	 * @see #getBoundaryConstraint()
	 * @generated
	 */
	EAttribute getBoundaryConstraint_Inclusive();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.URLConstraint <em>URL Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URL Constraint</em>'.
	 * @see org.m2ling.domain.core.URLConstraint
	 * @generated
	 */
	EClass getURLConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.NotNullConstraint <em>Not Null Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Null Constraint</em>'.
	 * @see org.m2ling.domain.core.NotNullConstraint
	 * @generated
	 */
	EClass getNotNullConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.RegexpConstraint <em>Regexp Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regexp Constraint</em>'.
	 * @see org.m2ling.domain.core.RegexpConstraint
	 * @generated
	 */
	EClass getRegexpConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.RegexpConstraint#getRegexp <em>Regexp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regexp</em>'.
	 * @see org.m2ling.domain.core.RegexpConstraint#getRegexp()
	 * @see #getRegexpConstraint()
	 * @generated
	 */
	EAttribute getRegexpConstraint_Regexp();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.OCLConstraint <em>OCL Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Constraint</em>'.
	 * @see org.m2ling.domain.core.OCLConstraint
	 * @generated
	 */
	EClass getOCLConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.OCLConstraint#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.m2ling.domain.core.OCLConstraint#getExpression()
	 * @see #getOCLConstraint()
	 * @generated
	 */
	EAttribute getOCLConstraint_Expression();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.IntegerConstraint <em>Integer Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Constraint</em>'.
	 * @see org.m2ling.domain.core.IntegerConstraint
	 * @generated
	 */
	EClass getIntegerConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.MaxConstraint <em>Max Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Max Constraint</em>'.
	 * @see org.m2ling.domain.core.MaxConstraint
	 * @generated
	 */
	EClass getMaxConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.EMailConstraint <em>EMail Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMail Constraint</em>'.
	 * @see org.m2ling.domain.core.EMailConstraint
	 * @generated
	 */
	EClass getEMailConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.FormatConstraint <em>Format Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Format Constraint</em>'.
	 * @see org.m2ling.domain.core.FormatConstraint
	 * @generated
	 */
	EClass getFormatConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.HasConstraints <em>Has Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Constraints</em>'.
	 * @see org.m2ling.domain.core.HasConstraints
	 * @generated
	 */
	EClass getHasConstraints();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity</em>'.
	 * @see org.m2ling.domain.core.Activity
	 * @generated
	 */
	EClass getActivity();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Activity#getResponsibles <em>Responsibles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Responsibles</em>'.
	 * @see org.m2ling.domain.core.Activity#getResponsibles()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Responsibles();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Activity#getAccountables <em>Accountables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Accountables</em>'.
	 * @see org.m2ling.domain.core.Activity#getAccountables()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Accountables();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.ActivityTransition <em>Activity Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Transition</em>'.
	 * @see org.m2ling.domain.core.ActivityTransition
	 * @generated
	 */
	EClass getActivityTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.ActivityTransition#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.m2ling.domain.core.ActivityTransition#getDate()
	 * @see #getActivityTransition()
	 * @generated
	 */
	EAttribute getActivityTransition_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.ActivityTransition#getFromStatus <em>From Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Status</em>'.
	 * @see org.m2ling.domain.core.ActivityTransition#getFromStatus()
	 * @see #getActivityTransition()
	 * @generated
	 */
	EAttribute getActivityTransition_FromStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.ActivityTransition#getToStatus <em>To Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Status</em>'.
	 * @see org.m2ling.domain.core.ActivityTransition#getToStatus()
	 * @see #getActivityTransition()
	 * @generated
	 */
	EAttribute getActivityTransition_ToStatus();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.ActivityTransition#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity</em>'.
	 * @see org.m2ling.domain.core.ActivityTransition#getActivity()
	 * @see #getActivityTransition()
	 * @generated
	 */
	EReference getActivityTransition_Activity();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.ActivityTransition#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actor</em>'.
	 * @see org.m2ling.domain.core.ActivityTransition#getActor()
	 * @see #getActivityTransition()
	 * @generated
	 */
	EReference getActivityTransition_Actor();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.OrganisationalUnit <em>Organisational Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organisational Unit</em>'.
	 * @see org.m2ling.domain.core.OrganisationalUnit
	 * @generated
	 */
	EClass getOrganisationalUnit();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see org.m2ling.domain.core.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Actor#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stakeholders</em>'.
	 * @see org.m2ling.domain.core.Actor#getStakeholders()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Stakeholders();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Actor#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unit</em>'.
	 * @see org.m2ling.domain.core.Actor#getUnit()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Unit();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.Actor#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.m2ling.domain.core.Actor#getUsername()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Username();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.Actor#isAdmin <em>Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Admin</em>'.
	 * @see org.m2ling.domain.core.Actor#isAdmin()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Admin();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.Actor#getPwdHash <em>Pwd Hash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pwd Hash</em>'.
	 * @see org.m2ling.domain.core.Actor#getPwdHash()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_PwdHash();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.Actor#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.m2ling.domain.core.Actor#getFirstName()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.Actor#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.m2ling.domain.core.Actor#getLastName()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_LastName();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.m2ling.domain.core.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.Rule#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.m2ling.domain.core.Rule#getStatus()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.Rule#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.m2ling.domain.core.Rule#getPriority()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Priority();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.HasLabel <em>Has Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Label</em>'.
	 * @see org.m2ling.domain.core.HasLabel
	 * @generated
	 */
	EClass getHasLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.HasLabel#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.m2ling.domain.core.HasLabel#getLabel()
	 * @see #getHasLabel()
	 * @generated
	 */
	EAttribute getHasLabel_Label();

	/**
	 * Returns the meta object for enum '{@link org.m2ling.domain.core.CustomPropertyType <em>Custom Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Custom Property Type</em>'.
	 * @see org.m2ling.domain.core.CustomPropertyType
	 * @generated
	 */
	EEnum getCustomPropertyType();

	/**
	 * Returns the meta object for enum '{@link org.m2ling.domain.core.ActivityStatus <em>Activity Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Activity Status</em>'.
	 * @see org.m2ling.domain.core.ActivityStatus
	 * @generated
	 */
	EEnum getActivityStatus();

	/**
	 * Returns the meta object for enum '{@link org.m2ling.domain.core.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see org.m2ling.domain.core.Type
	 * @generated
	 */
	EEnum getType();

	/**
	 * Returns the meta object for enum '{@link org.m2ling.domain.core.RuleStatus <em>Rule Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Status</em>'.
	 * @see org.m2ling.domain.core.RuleStatus
	 * @generated
	 */
	EEnum getRuleStatus();

	/**
	 * Returns the meta object for enum '{@link org.m2ling.domain.core.RulePriority <em>Rule Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Priority</em>'.
	 * @see org.m2ling.domain.core.RulePriority
	 * @generated
	 */
	EEnum getRulePriority();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreFactory getCoreFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ComponentTypeImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentType()
		 * @generated
		 */
		EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

		/**
		 * The meta object literal for the '<em><b>Sub Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__SUB_TYPES = eINSTANCE.getComponentType_SubTypes();

		/**
		 * The meta object literal for the '<em><b>Binded Component Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__BINDED_COMPONENT_TYPE = eINSTANCE.getComponentType_BindedComponentType();

		/**
		 * The meta object literal for the '<em><b>Engine Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__ENGINE_TYPE = eINSTANCE.getComponentType_EngineType();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ComponentImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__TYPE = eINSTANCE.getComponent_Type();

		/**
		 * The meta object literal for the '<em><b>Sub Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__SUB_COMPONENTS = eINSTANCE.getComponent_SubComponents();

		/**
		 * The meta object literal for the '<em><b>Engine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__ENGINE = eINSTANCE.getComponent_Engine();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.HasNameAndIDImpl <em>Has Name And ID</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.HasNameAndIDImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasNameAndID()
		 * @generated
		 */
		EClass HAS_NAME_AND_ID = eINSTANCE.getHasNameAndID();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAS_NAME_AND_ID__ID = eINSTANCE.getHasNameAndID_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAS_NAME_AND_ID__NAME = eINSTANCE.getHasNameAndID_Name();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ComponentNodeImpl <em>Component Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ComponentNodeImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentNode()
		 * @generated
		 */
		EClass COMPONENT_NODE = eINSTANCE.getComponentNode();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_NODE__COMPONENT = eINSTANCE.getComponentNode_Component();

		/**
		 * The meta object literal for the '<em><b>Sub Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_NODE__SUB_NODES = eINSTANCE.getComponentNode_SubNodes();

		/**
		 * The meta object literal for the '<em><b>Engine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_NODE__ENGINE = eINSTANCE.getComponentNode_Engine();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ViewPointImpl <em>View Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ViewPointImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getViewPoint()
		 * @generated
		 */
		EClass VIEW_POINT = eINSTANCE.getViewPoint();

		/**
		 * The meta object literal for the '<em><b>Component Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_POINT__COMPONENT_TYPES = eINSTANCE.getViewPoint_ComponentTypes();

		/**
		 * The meta object literal for the '<em><b>Activities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_POINT__ACTIVITIES = eINSTANCE.getViewPoint_Activities();

		/**
		 * The meta object literal for the '<em><b>Base Viewpoint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_POINT__BASE_VIEWPOINT = eINSTANCE.getViewPoint_BaseViewpoint();

		/**
		 * The meta object literal for the '<em><b>Link Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_POINT__LINK_TYPES = eINSTANCE.getViewPoint_LinkTypes();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_POINT__RULES = eINSTANCE.getViewPoint_Rules();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ComponentGroupImpl <em>Component Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ComponentGroupImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentGroup()
		 * @generated
		 */
		EClass COMPONENT_GROUP = eINSTANCE.getComponentGroup();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_GROUP__COMPONENTS = eINSTANCE.getComponentGroup_Components();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ComponentNodeGroupImpl <em>Component Node Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ComponentNodeGroupImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentNodeGroup()
		 * @generated
		 */
		EClass COMPONENT_NODE_GROUP = eINSTANCE.getComponentNodeGroup();

		/**
		 * The meta object literal for the '<em><b>Component Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_NODE_GROUP__COMPONENT_NODES = eINSTANCE.getComponentNodeGroup_ComponentNodes();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ArchitectureItemImpl <em>Architecture Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ArchitectureItemImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getArchitectureItem()
		 * @generated
		 */
		EClass ARCHITECTURE_ITEM = eINSTANCE.getArchitectureItem();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ConceptItemImpl <em>Concept Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ConceptItemImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getConceptItem()
		 * @generated
		 */
		EClass CONCEPT_ITEM = eINSTANCE.getConceptItem();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.RuntimeItemImpl <em>Runtime Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.RuntimeItemImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRuntimeItem()
		 * @generated
		 */
		EClass RUNTIME_ITEM = eINSTANCE.getRuntimeItem();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ViewImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Components Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__COMPONENTS_GROUPS = eINSTANCE.getView_ComponentsGroups();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__COMPONENTS = eINSTANCE.getView_Components();

		/**
		 * The meta object literal for the '<em><b>View Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__VIEW_POINT = eINSTANCE.getView_ViewPoint();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__LINKS = eINSTANCE.getView_Links();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.HasTagsImpl <em>Has Tags</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.HasTagsImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasTags()
		 * @generated
		 */
		EClass HAS_TAGS = eINSTANCE.getHasTags();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAS_TAGS__TAGS = eINSTANCE.getHasTags_Tags();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.HasCommentImpl <em>Has Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.HasCommentImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasComment()
		 * @generated
		 */
		EClass HAS_COMMENT = eINSTANCE.getHasComment();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAS_COMMENT__COMMENT = eINSTANCE.getHasComment_Comment();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.HasCustomPropertiesImpl <em>Has Custom Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.HasCustomPropertiesImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasCustomProperties()
		 * @generated
		 */
		EClass HAS_CUSTOM_PROPERTIES = eINSTANCE.getHasCustomProperties();

		/**
		 * The meta object literal for the '<em><b>Custom Properties</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES = eINSTANCE.getHasCustomProperties_CustomProperties();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.CustomPropertyImpl <em>Custom Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.CustomPropertyImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getCustomProperty()
		 * @generated
		 */
		EClass CUSTOM_PROPERTY = eINSTANCE.getCustomProperty();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.LinkTypeImpl <em>Link Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.LinkTypeImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getLinkType()
		 * @generated
		 */
		EClass LINK_TYPE = eINSTANCE.getLinkType();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_TYPE__SOURCE_TYPE = eINSTANCE.getLinkType_SourceType();

		/**
		 * The meta object literal for the '<em><b>Destination Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_TYPE__DESTINATION_TYPE = eINSTANCE.getLinkType_DestinationType();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.LinkImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TYPE = eINSTANCE.getLink_Type();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__SOURCE = eINSTANCE.getLink_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__DESTINATION = eINSTANCE.getLink_Destination();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.StreamImpl <em>Stream</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.StreamImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getStream()
		 * @generated
		 */
		EClass STREAM = eINSTANCE.getStream();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM__SOURCE = eINSTANCE.getStream_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM__DESTINATION = eINSTANCE.getStream_Destination();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM__TYPE = eINSTANCE.getStream_Type();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.HasParameterDefinitionsImpl <em>Has Parameter Definitions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.HasParameterDefinitionsImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasParameterDefinitions()
		 * @generated
		 */
		EClass HAS_PARAMETER_DEFINITIONS = eINSTANCE.getHasParameterDefinitions();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.HasParameterValuesImpl <em>Has Parameter Values</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.HasParameterValuesImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasParameterValues()
		 * @generated
		 */
		EClass HAS_PARAMETER_VALUES = eINSTANCE.getHasParameterValues();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.StakeholderImpl <em>Stakeholder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.StakeholderImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getStakeholder()
		 * @generated
		 */
		EClass STAKEHOLDER = eINSTANCE.getStakeholder();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER__VIEWS = eINSTANCE.getStakeholder_Views();

		/**
		 * The meta object literal for the '<em><b>View Points</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER__VIEW_POINTS = eINSTANCE.getStakeholder_ViewPoints();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER__ACTORS = eINSTANCE.getStakeholder_Actors();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.FloatConstraintImpl <em>Float Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.FloatConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getFloatConstraint()
		 * @generated
		 */
		EClass FLOAT_CONSTRAINT = eINSTANCE.getFloatConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.MinConstraintImpl <em>Min Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.MinConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getMinConstraint()
		 * @generated
		 */
		EClass MIN_CONSTRAINT = eINSTANCE.getMinConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.BoundaryConstraintImpl <em>Boundary Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.BoundaryConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getBoundaryConstraint()
		 * @generated
		 */
		EClass BOUNDARY_CONSTRAINT = eINSTANCE.getBoundaryConstraint();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDARY_CONSTRAINT__VALUE = eINSTANCE.getBoundaryConstraint_Value();

		/**
		 * The meta object literal for the '<em><b>Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDARY_CONSTRAINT__INCLUSIVE = eINSTANCE.getBoundaryConstraint_Inclusive();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.URLConstraintImpl <em>URL Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.URLConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getURLConstraint()
		 * @generated
		 */
		EClass URL_CONSTRAINT = eINSTANCE.getURLConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.NotNullConstraintImpl <em>Not Null Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.NotNullConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getNotNullConstraint()
		 * @generated
		 */
		EClass NOT_NULL_CONSTRAINT = eINSTANCE.getNotNullConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.RegexpConstraintImpl <em>Regexp Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.RegexpConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRegexpConstraint()
		 * @generated
		 */
		EClass REGEXP_CONSTRAINT = eINSTANCE.getRegexpConstraint();

		/**
		 * The meta object literal for the '<em><b>Regexp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGEXP_CONSTRAINT__REGEXP = eINSTANCE.getRegexpConstraint_Regexp();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.OCLConstraintImpl <em>OCL Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.OCLConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getOCLConstraint()
		 * @generated
		 */
		EClass OCL_CONSTRAINT = eINSTANCE.getOCLConstraint();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_CONSTRAINT__EXPRESSION = eINSTANCE.getOCLConstraint_Expression();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.IntegerConstraintImpl <em>Integer Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.IntegerConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getIntegerConstraint()
		 * @generated
		 */
		EClass INTEGER_CONSTRAINT = eINSTANCE.getIntegerConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.MaxConstraintImpl <em>Max Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.MaxConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getMaxConstraint()
		 * @generated
		 */
		EClass MAX_CONSTRAINT = eINSTANCE.getMaxConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.EMailConstraintImpl <em>EMail Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.EMailConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEMailConstraint()
		 * @generated
		 */
		EClass EMAIL_CONSTRAINT = eINSTANCE.getEMailConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.FormatConstraintImpl <em>Format Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.FormatConstraintImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getFormatConstraint()
		 * @generated
		 */
		EClass FORMAT_CONSTRAINT = eINSTANCE.getFormatConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.HasConstraintsImpl <em>Has Constraints</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.HasConstraintsImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasConstraints()
		 * @generated
		 */
		EClass HAS_CONSTRAINTS = eINSTANCE.getHasConstraints();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ActivityImpl <em>Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ActivityImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getActivity()
		 * @generated
		 */
		EClass ACTIVITY = eINSTANCE.getActivity();

		/**
		 * The meta object literal for the '<em><b>Responsibles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__RESPONSIBLES = eINSTANCE.getActivity_Responsibles();

		/**
		 * The meta object literal for the '<em><b>Accountables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__ACCOUNTABLES = eINSTANCE.getActivity_Accountables();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ActivityTransitionImpl <em>Activity Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ActivityTransitionImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getActivityTransition()
		 * @generated
		 */
		EClass ACTIVITY_TRANSITION = eINSTANCE.getActivityTransition();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_TRANSITION__DATE = eINSTANCE.getActivityTransition_Date();

		/**
		 * The meta object literal for the '<em><b>From Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_TRANSITION__FROM_STATUS = eINSTANCE.getActivityTransition_FromStatus();

		/**
		 * The meta object literal for the '<em><b>To Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_TRANSITION__TO_STATUS = eINSTANCE.getActivityTransition_ToStatus();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_TRANSITION__ACTIVITY = eINSTANCE.getActivityTransition_Activity();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_TRANSITION__ACTOR = eINSTANCE.getActivityTransition_Actor();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.OrganisationalUnitImpl <em>Organisational Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.OrganisationalUnitImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getOrganisationalUnit()
		 * @generated
		 */
		EClass ORGANISATIONAL_UNIT = eINSTANCE.getOrganisationalUnit();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ActorImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Stakeholders</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__STAKEHOLDERS = eINSTANCE.getActor_Stakeholders();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__UNIT = eINSTANCE.getActor_Unit();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__USERNAME = eINSTANCE.getActor_Username();

		/**
		 * The meta object literal for the '<em><b>Admin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__ADMIN = eINSTANCE.getActor_Admin();

		/**
		 * The meta object literal for the '<em><b>Pwd Hash</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__PWD_HASH = eINSTANCE.getActor_PwdHash();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__FIRST_NAME = eINSTANCE.getActor_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__LAST_NAME = eINSTANCE.getActor_LastName();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.RuleImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__STATUS = eINSTANCE.getRule_Status();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__PRIORITY = eINSTANCE.getRule_Priority();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.HasLabelImpl <em>Has Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.HasLabelImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasLabel()
		 * @generated
		 */
		EClass HAS_LABEL = eINSTANCE.getHasLabel();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAS_LABEL__LABEL = eINSTANCE.getHasLabel_Label();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.CustomPropertyType <em>Custom Property Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.CustomPropertyType
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getCustomPropertyType()
		 * @generated
		 */
		EEnum CUSTOM_PROPERTY_TYPE = eINSTANCE.getCustomPropertyType();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.ActivityStatus <em>Activity Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.ActivityStatus
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getActivityStatus()
		 * @generated
		 */
		EEnum ACTIVITY_STATUS = eINSTANCE.getActivityStatus();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.Type
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.RuleStatus <em>Rule Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.RuleStatus
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRuleStatus()
		 * @generated
		 */
		EEnum RULE_STATUS = eINSTANCE.getRuleStatus();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.RulePriority <em>Rule Priority</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.RulePriority
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRulePriority()
		 * @generated
		 */
		EEnum RULE_PRIORITY = eINSTANCE.getRulePriority();

	}

} //CorePackage
