/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
	String eNS_URI = "http://m2ling.org/core/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CorePackage eINSTANCE = org.m2ling.domain.core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasNameImpl <em>Has Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasNameImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasName()
	 * @generated
	 */
	int HAS_NAME = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NAME__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NAME__NAME = 1;

	/**
	 * The number of structural features of the '<em>Has Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NAME_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ConceptItemImpl <em>Concept Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ConceptItemImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getConceptItem()
	 * @generated
	 */
	int CONCEPT_ITEM = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM__ID = HAS_NAME__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM__NAME = HAS_NAME__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM__VERSION = HAS_NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Concept Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_ITEM_FEATURE_COUNT = HAS_NAME_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.EngineTypeImpl <em>Engine Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.EngineTypeImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEngineType()
	 * @generated
	 */
	int ENGINE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_TYPE__ID = CONCEPT_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_TYPE__NAME = CONCEPT_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_TYPE__VERSION = CONCEPT_ITEM__VERSION;

	/**
	 * The feature id for the '<em><b>Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_TYPE__COMPONENT_TYPES = CONCEPT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_TYPE__SUB_TYPES = CONCEPT_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_TYPE__PARENT = CONCEPT_ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Engine Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_TYPE_FEATURE_COUNT = CONCEPT_ITEM_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ComponentTypeImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 1;

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
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__VERSION = CONCEPT_ITEM__VERSION;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__SUB_TYPES = CONCEPT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Engine Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__ENGINE_TYPE = CONCEPT_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__PARENT = CONCEPT_ITEM_FEATURE_COUNT + 2;

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
	int ARCHITECTURE_ITEM = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ITEM__ID = HAS_NAME__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ITEM__NAME = HAS_NAME__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ITEM__VERSION = HAS_NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Architecture Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ITEM_FEATURE_COUNT = HAS_NAME_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.EngineGroupImpl <em>Engine Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.EngineGroupImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEngineGroup()
	 * @generated
	 */
	int ENGINE_GROUP = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_GROUP__ID = ARCHITECTURE_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_GROUP__NAME = ARCHITECTURE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_GROUP__VERSION = ARCHITECTURE_ITEM__VERSION;

	/**
	 * The feature id for the '<em><b>Engines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_GROUP__ENGINES = ARCHITECTURE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Engine Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_GROUP_FEATURE_COUNT = ARCHITECTURE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.EngineImpl <em>Engine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.EngineImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEngine()
	 * @generated
	 */
	int ENGINE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__ID = ENGINE_GROUP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__NAME = ENGINE_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__VERSION = ENGINE_GROUP__VERSION;

	/**
	 * The feature id for the '<em><b>Engines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__ENGINES = ENGINE_GROUP__ENGINES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__TYPE = ENGINE_GROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Engines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__SUB_ENGINES = ENGINE_GROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__COMPONENTS = ENGINE_GROUP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__PARENT = ENGINE_GROUP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_FEATURE_COUNT = ENGINE_GROUP_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ComponentGroupImpl <em>Component Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ComponentGroupImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentGroup()
	 * @generated
	 */
	int COMPONENT_GROUP = 9;

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
	 * The feature id for the '<em><b>Version</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_GROUP__VERSION = ARCHITECTURE_ITEM__VERSION;

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
	int COMPONENT = 3;

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
	 * The feature id for the '<em><b>Version</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__VERSION = COMPONENT_GROUP__VERSION;

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
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PARENT = COMPONENT_GROUP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ifactor</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__IFACTOR = COMPONENT_GROUP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = COMPONENT_GROUP_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.RuntimeItemImpl <em>Runtime Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.RuntimeItemImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getRuntimeItem()
	 * @generated
	 */
	int RUNTIME_ITEM = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_ITEM__ID = HAS_NAME__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_ITEM__NAME = HAS_NAME__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_ITEM__VERSION = HAS_NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Runtime Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_ITEM_FEATURE_COUNT = HAS_NAME_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.EngineNodeGroupImpl <em>Engine Node Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.EngineNodeGroupImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEngineNodeGroup()
	 * @generated
	 */
	int ENGINE_NODE_GROUP = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE_GROUP__ID = RUNTIME_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE_GROUP__NAME = RUNTIME_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE_GROUP__VERSION = RUNTIME_ITEM__VERSION;

	/**
	 * The feature id for the '<em><b>Engine Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE_GROUP__ENGINE_NODES = RUNTIME_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Engine Node Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE_GROUP_FEATURE_COUNT = RUNTIME_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.EngineNodeImpl <em>Engine Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.EngineNodeImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEngineNode()
	 * @generated
	 */
	int ENGINE_NODE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE__ID = ENGINE_NODE_GROUP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE__NAME = ENGINE_NODE_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE__VERSION = ENGINE_NODE_GROUP__VERSION;

	/**
	 * The feature id for the '<em><b>Engine Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE__ENGINE_NODES = ENGINE_NODE_GROUP__ENGINE_NODES;

	/**
	 * The feature id for the '<em><b>Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE__ENGINE = ENGINE_NODE_GROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE__SUB_NODES = ENGINE_NODE_GROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE__COMPONENT_NODES = ENGINE_NODE_GROUP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE__PARENT = ENGINE_NODE_GROUP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Engine Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_NODE_FEATURE_COUNT = ENGINE_NODE_GROUP_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ComponentNodeGroupImpl <em>Component Node Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ComponentNodeGroupImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getComponentNodeGroup()
	 * @generated
	 */
	int COMPONENT_NODE_GROUP = 12;

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
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_GROUP__VERSION = RUNTIME_ITEM__VERSION;

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
	int COMPONENT_NODE = 6;

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
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__VERSION = COMPONENT_NODE_GROUP__VERSION;

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
	 * The feature id for the '<em><b>Engine Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__ENGINE_NODE = COMPONENT_NODE_GROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__SUB_NODES = COMPONENT_NODE_GROUP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__PARENT = COMPONENT_NODE_GROUP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Component Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_FEATURE_COUNT = COMPONENT_NODE_GROUP_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.EnvironnementImpl <em>Environnement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.EnvironnementImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEnvironnement()
	 * @generated
	 */
	int ENVIRONNEMENT = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONNEMENT__ID = RUNTIME_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONNEMENT__NAME = RUNTIME_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONNEMENT__VERSION = RUNTIME_ITEM__VERSION;

	/**
	 * The feature id for the '<em><b>Component Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONNEMENT__COMPONENT_NODES = RUNTIME_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Engine Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONNEMENT__ENGINE_NODES = RUNTIME_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component Node Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONNEMENT__COMPONENT_NODE_GROUPS = RUNTIME_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Engine Node Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONNEMENT__ENGINE_NODE_GROUPS = RUNTIME_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONNEMENT__PROFILE = RUNTIME_ITEM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Environnement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONNEMENT_FEATURE_COUNT = RUNTIME_ITEM_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ConceptsImpl <em>Concepts</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ConceptsImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getConcepts()
	 * @generated
	 */
	int CONCEPTS = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTS__ID = CONCEPT_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTS__NAME = CONCEPT_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTS__VERSION = CONCEPT_ITEM__VERSION;

	/**
	 * The feature id for the '<em><b>Component Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTS__COMPONENT_TYPES = CONCEPT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Engine Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTS__ENGINE_TYPES = CONCEPT_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Concepts</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTS_FEATURE_COUNT = CONCEPT_ITEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.ProjectImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ID = ARCHITECTURE_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = ARCHITECTURE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__VERSION = ARCHITECTURE_ITEM__VERSION;

	/**
	 * The feature id for the '<em><b>Components Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__COMPONENTS_GROUPS = ARCHITECTURE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__COMPONENTS = ARCHITECTURE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Engines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ENGINES = ARCHITECTURE_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Engine Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ENGINE_GROUPS = ARCHITECTURE_ITEM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = ARCHITECTURE_ITEM_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasTagsImpl <em>Has Tags</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasTagsImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasTags()
	 * @generated
	 */
	int HAS_TAGS = 17;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_TAGS__TAGS = 0;

	/**
	 * The feature id for the '<em><b>Tag Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_TAGS__TAG_GROUPS = 1;

	/**
	 * The number of structural features of the '<em>Has Tags</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_TAGS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.TagImpl <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.TagImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getTag()
	 * @generated
	 */
	int TAG = 18;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.TagGroupImpl <em>Tag Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.TagGroupImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getTagGroup()
	 * @generated
	 */
	int TAG_GROUP = 19;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_GROUP__TAGS = 0;

	/**
	 * The number of structural features of the '<em>Tag Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_GROUP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasCommentImpl <em>Has Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasCommentImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasComment()
	 * @generated
	 */
	int HAS_COMMENT = 20;

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
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.HasCustomPropertiesImpl <em>Has Custom Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.HasCustomPropertiesImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasCustomProperties()
	 * @generated
	 */
	int HAS_CUSTOM_PROPERTIES = 21;

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
	int CUSTOM_PROPERTY = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY__DEFAULT_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY__VALUE = 3;

	/**
	 * The number of structural features of the '<em>Custom Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.LinkTypeImpl <em>Link Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.LinkTypeImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getLinkType()
	 * @generated
	 */
	int LINK_TYPE = 23;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__SOURCE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Destination Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__DESTINATION_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.LinkImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getLink()
	 * @generated
	 */
	int LINK = 24;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__DESTINATION = 2;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.impl.StreamImpl <em>Stream</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.impl.StreamImpl
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getStream()
	 * @generated
	 */
	int STREAM = 25;

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
	int HAS_PARAMETER_DEFINITIONS = 26;

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
	int HAS_PARAMETER_VALUES = 27;

	/**
	 * The number of structural features of the '<em>Has Parameter Values</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_PARAMETER_VALUES_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.core.CustomPropertyType <em>Custom Property Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.core.CustomPropertyType
	 * @see org.m2ling.domain.core.impl.CorePackageImpl#getCustomPropertyType()
	 * @generated
	 */
	int CUSTOM_PROPERTY_TYPE = 28;


	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.EngineType <em>Engine Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine Type</em>'.
	 * @see org.m2ling.domain.core.EngineType
	 * @generated
	 */
	EClass getEngineType();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.EngineType#getComponentTypes <em>Component Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Component Types</em>'.
	 * @see org.m2ling.domain.core.EngineType#getComponentTypes()
	 * @see #getEngineType()
	 * @generated
	 */
	EReference getEngineType_ComponentTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.EngineType#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Types</em>'.
	 * @see org.m2ling.domain.core.EngineType#getSubTypes()
	 * @see #getEngineType()
	 * @generated
	 */
	EReference getEngineType_SubTypes();

	/**
	 * Returns the meta object for the container reference '{@link org.m2ling.domain.core.EngineType#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.m2ling.domain.core.EngineType#getParent()
	 * @see #getEngineType()
	 * @generated
	 */
	EReference getEngineType_Parent();

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
	 * Returns the meta object for the container reference '{@link org.m2ling.domain.core.ComponentType#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.m2ling.domain.core.ComponentType#getParent()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Parent();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Engine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine</em>'.
	 * @see org.m2ling.domain.core.Engine
	 * @generated
	 */
	EClass getEngine();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.Engine#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.m2ling.domain.core.Engine#getType()
	 * @see #getEngine()
	 * @generated
	 */
	EReference getEngine_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.Engine#getSubEngines <em>Sub Engines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Engines</em>'.
	 * @see org.m2ling.domain.core.Engine#getSubEngines()
	 * @see #getEngine()
	 * @generated
	 */
	EReference getEngine_SubEngines();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Engine#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Components</em>'.
	 * @see org.m2ling.domain.core.Engine#getComponents()
	 * @see #getEngine()
	 * @generated
	 */
	EReference getEngine_Components();

	/**
	 * Returns the meta object for the container reference '{@link org.m2ling.domain.core.Engine#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.m2ling.domain.core.Engine#getParent()
	 * @see #getEngine()
	 * @generated
	 */
	EReference getEngine_Parent();

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
	 * Returns the meta object for the container reference '{@link org.m2ling.domain.core.Component#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.m2ling.domain.core.Component#getParent()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Parent();

	/**
	 * Returns the meta object for the attribute list '{@link org.m2ling.domain.core.Component#getIfactor <em>Ifactor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ifactor</em>'.
	 * @see org.m2ling.domain.core.Component#getIfactor()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Ifactor();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.HasName <em>Has Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Name</em>'.
	 * @see org.m2ling.domain.core.HasName
	 * @generated
	 */
	EClass getHasName();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.HasName#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.m2ling.domain.core.HasName#getId()
	 * @see #getHasName()
	 * @generated
	 */
	EAttribute getHasName_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.HasName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.m2ling.domain.core.HasName#getName()
	 * @see #getHasName()
	 * @generated
	 */
	EAttribute getHasName_Name();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.EngineNode <em>Engine Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine Node</em>'.
	 * @see org.m2ling.domain.core.EngineNode
	 * @generated
	 */
	EClass getEngineNode();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.EngineNode#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Engine</em>'.
	 * @see org.m2ling.domain.core.EngineNode#getEngine()
	 * @see #getEngineNode()
	 * @generated
	 */
	EReference getEngineNode_Engine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.EngineNode#getSubNodes <em>Sub Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Nodes</em>'.
	 * @see org.m2ling.domain.core.EngineNode#getSubNodes()
	 * @see #getEngineNode()
	 * @generated
	 */
	EReference getEngineNode_SubNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.EngineNode#getComponentNodes <em>Component Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Component Nodes</em>'.
	 * @see org.m2ling.domain.core.EngineNode#getComponentNodes()
	 * @see #getEngineNode()
	 * @generated
	 */
	EReference getEngineNode_ComponentNodes();

	/**
	 * Returns the meta object for the container reference '{@link org.m2ling.domain.core.EngineNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.m2ling.domain.core.EngineNode#getParent()
	 * @see #getEngineNode()
	 * @generated
	 */
	EReference getEngineNode_Parent();

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
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.ComponentNode#getEngineNode <em>Engine Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Engine Node</em>'.
	 * @see org.m2ling.domain.core.ComponentNode#getEngineNode()
	 * @see #getComponentNode()
	 * @generated
	 */
	EReference getComponentNode_EngineNode();

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
	 * Returns the meta object for the container reference '{@link org.m2ling.domain.core.ComponentNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.m2ling.domain.core.ComponentNode#getParent()
	 * @see #getComponentNode()
	 * @generated
	 */
	EReference getComponentNode_Parent();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Environnement <em>Environnement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environnement</em>'.
	 * @see org.m2ling.domain.core.Environnement
	 * @generated
	 */
	EClass getEnvironnement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.Environnement#getComponentNodes <em>Component Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Nodes</em>'.
	 * @see org.m2ling.domain.core.Environnement#getComponentNodes()
	 * @see #getEnvironnement()
	 * @generated
	 */
	EReference getEnvironnement_ComponentNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.Environnement#getEngineNodes <em>Engine Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Engine Nodes</em>'.
	 * @see org.m2ling.domain.core.Environnement#getEngineNodes()
	 * @see #getEnvironnement()
	 * @generated
	 */
	EReference getEnvironnement_EngineNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.Environnement#getComponentNodeGroups <em>Component Node Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Node Groups</em>'.
	 * @see org.m2ling.domain.core.Environnement#getComponentNodeGroups()
	 * @see #getEnvironnement()
	 * @generated
	 */
	EReference getEnvironnement_ComponentNodeGroups();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.Environnement#getEngineNodeGroups <em>Engine Node Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Engine Node Groups</em>'.
	 * @see org.m2ling.domain.core.Environnement#getEngineNodeGroups()
	 * @see #getEnvironnement()
	 * @generated
	 */
	EReference getEnvironnement_EngineNodeGroups();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.Environnement#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile</em>'.
	 * @see org.m2ling.domain.core.Environnement#getProfile()
	 * @see #getEnvironnement()
	 * @generated
	 */
	EAttribute getEnvironnement_Profile();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Concepts <em>Concepts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concepts</em>'.
	 * @see org.m2ling.domain.core.Concepts
	 * @generated
	 */
	EClass getConcepts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.Concepts#getComponentTypes <em>Component Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Types</em>'.
	 * @see org.m2ling.domain.core.Concepts#getComponentTypes()
	 * @see #getConcepts()
	 * @generated
	 */
	EReference getConcepts_ComponentTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.core.Concepts#getEngineTypes <em>Engine Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Engine Types</em>'.
	 * @see org.m2ling.domain.core.Concepts#getEngineTypes()
	 * @see #getConcepts()
	 * @generated
	 */
	EReference getConcepts_EngineTypes();

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
	 * Returns the meta object for class '{@link org.m2ling.domain.core.EngineGroup <em>Engine Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine Group</em>'.
	 * @see org.m2ling.domain.core.EngineGroup
	 * @generated
	 */
	EClass getEngineGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.EngineGroup#getEngines <em>Engines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Engines</em>'.
	 * @see org.m2ling.domain.core.EngineGroup#getEngines()
	 * @see #getEngineGroup()
	 * @generated
	 */
	EReference getEngineGroup_Engines();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.EngineNodeGroup <em>Engine Node Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine Node Group</em>'.
	 * @see org.m2ling.domain.core.EngineNodeGroup
	 * @generated
	 */
	EClass getEngineNodeGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.EngineNodeGroup#getEngineNodes <em>Engine Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Engine Nodes</em>'.
	 * @see org.m2ling.domain.core.EngineNodeGroup#getEngineNodes()
	 * @see #getEngineNodeGroup()
	 * @generated
	 */
	EReference getEngineNodeGroup_EngineNodes();

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
	 * Returns the meta object for the attribute list '{@link org.m2ling.domain.core.ArchitectureItem#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Version</em>'.
	 * @see org.m2ling.domain.core.ArchitectureItem#getVersion()
	 * @see #getArchitectureItem()
	 * @generated
	 */
	EAttribute getArchitectureItem_Version();

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
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.ConceptItem#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.m2ling.domain.core.ConceptItem#getVersion()
	 * @see #getConceptItem()
	 * @generated
	 */
	EAttribute getConceptItem_Version();

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
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.RuntimeItem#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.m2ling.domain.core.RuntimeItem#getVersion()
	 * @see #getRuntimeItem()
	 * @generated
	 */
	EAttribute getRuntimeItem_Version();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.m2ling.domain.core.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Project#getComponentsGroups <em>Components Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Components Groups</em>'.
	 * @see org.m2ling.domain.core.Project#getComponentsGroups()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_ComponentsGroups();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Project#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Components</em>'.
	 * @see org.m2ling.domain.core.Project#getComponents()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Components();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Project#getEngines <em>Engines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Engines</em>'.
	 * @see org.m2ling.domain.core.Project#getEngines()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Engines();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.Project#getEngineGroups <em>Engine Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Engine Groups</em>'.
	 * @see org.m2ling.domain.core.Project#getEngineGroups()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_EngineGroups();

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
	 * Returns the meta object for the reference '{@link org.m2ling.domain.core.HasTags#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tags</em>'.
	 * @see org.m2ling.domain.core.HasTags#getTags()
	 * @see #getHasTags()
	 * @generated
	 */
	EReference getHasTags_Tags();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.HasTags#getTagGroups <em>Tag Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tag Groups</em>'.
	 * @see org.m2ling.domain.core.HasTags#getTagGroups()
	 * @see #getHasTags()
	 * @generated
	 */
	EReference getHasTags_TagGroups();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see org.m2ling.domain.core.Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.Tag#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.m2ling.domain.core.Tag#getValue()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Value();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.core.TagGroup <em>Tag Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Group</em>'.
	 * @see org.m2ling.domain.core.TagGroup
	 * @generated
	 */
	EClass getTagGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.m2ling.domain.core.TagGroup#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tags</em>'.
	 * @see org.m2ling.domain.core.TagGroup#getTags()
	 * @see #getTagGroup()
	 * @generated
	 */
	EReference getTagGroup_Tags();

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
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.CustomProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.m2ling.domain.core.CustomProperty#getName()
	 * @see #getCustomProperty()
	 * @generated
	 */
	EAttribute getCustomProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.CustomProperty#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see org.m2ling.domain.core.CustomProperty#getDefaultValue()
	 * @see #getCustomProperty()
	 * @generated
	 */
	EAttribute getCustomProperty_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.CustomProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.m2ling.domain.core.CustomProperty#getType()
	 * @see #getCustomProperty()
	 * @generated
	 */
	EAttribute getCustomProperty_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.core.CustomProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.m2ling.domain.core.CustomProperty#getValue()
	 * @see #getCustomProperty()
	 * @generated
	 */
	EAttribute getCustomProperty_Value();

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
	 * Returns the meta object for enum '{@link org.m2ling.domain.core.CustomPropertyType <em>Custom Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Custom Property Type</em>'.
	 * @see org.m2ling.domain.core.CustomPropertyType
	 * @generated
	 */
	EEnum getCustomPropertyType();

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
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.EngineTypeImpl <em>Engine Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.EngineTypeImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEngineType()
		 * @generated
		 */
		EClass ENGINE_TYPE = eINSTANCE.getEngineType();

		/**
		 * The meta object literal for the '<em><b>Component Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE_TYPE__COMPONENT_TYPES = eINSTANCE.getEngineType_ComponentTypes();

		/**
		 * The meta object literal for the '<em><b>Sub Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE_TYPE__SUB_TYPES = eINSTANCE.getEngineType_SubTypes();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE_TYPE__PARENT = eINSTANCE.getEngineType_Parent();

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
		 * The meta object literal for the '<em><b>Engine Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__ENGINE_TYPE = eINSTANCE.getComponentType_EngineType();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__PARENT = eINSTANCE.getComponentType_Parent();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.EngineImpl <em>Engine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.EngineImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEngine()
		 * @generated
		 */
		EClass ENGINE = eINSTANCE.getEngine();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE__TYPE = eINSTANCE.getEngine_Type();

		/**
		 * The meta object literal for the '<em><b>Sub Engines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE__SUB_ENGINES = eINSTANCE.getEngine_SubEngines();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE__COMPONENTS = eINSTANCE.getEngine_Components();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE__PARENT = eINSTANCE.getEngine_Parent();

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
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PARENT = eINSTANCE.getComponent_Parent();

		/**
		 * The meta object literal for the '<em><b>Ifactor</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__IFACTOR = eINSTANCE.getComponent_Ifactor();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.HasNameImpl <em>Has Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.HasNameImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getHasName()
		 * @generated
		 */
		EClass HAS_NAME = eINSTANCE.getHasName();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAS_NAME__ID = eINSTANCE.getHasName_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAS_NAME__NAME = eINSTANCE.getHasName_Name();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.EngineNodeImpl <em>Engine Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.EngineNodeImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEngineNode()
		 * @generated
		 */
		EClass ENGINE_NODE = eINSTANCE.getEngineNode();

		/**
		 * The meta object literal for the '<em><b>Engine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE_NODE__ENGINE = eINSTANCE.getEngineNode_Engine();

		/**
		 * The meta object literal for the '<em><b>Sub Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE_NODE__SUB_NODES = eINSTANCE.getEngineNode_SubNodes();

		/**
		 * The meta object literal for the '<em><b>Component Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE_NODE__COMPONENT_NODES = eINSTANCE.getEngineNode_ComponentNodes();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE_NODE__PARENT = eINSTANCE.getEngineNode_Parent();

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
		 * The meta object literal for the '<em><b>Engine Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_NODE__ENGINE_NODE = eINSTANCE.getComponentNode_EngineNode();

		/**
		 * The meta object literal for the '<em><b>Sub Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_NODE__SUB_NODES = eINSTANCE.getComponentNode_SubNodes();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_NODE__PARENT = eINSTANCE.getComponentNode_Parent();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.EnvironnementImpl <em>Environnement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.EnvironnementImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEnvironnement()
		 * @generated
		 */
		EClass ENVIRONNEMENT = eINSTANCE.getEnvironnement();

		/**
		 * The meta object literal for the '<em><b>Component Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONNEMENT__COMPONENT_NODES = eINSTANCE.getEnvironnement_ComponentNodes();

		/**
		 * The meta object literal for the '<em><b>Engine Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONNEMENT__ENGINE_NODES = eINSTANCE.getEnvironnement_EngineNodes();

		/**
		 * The meta object literal for the '<em><b>Component Node Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONNEMENT__COMPONENT_NODE_GROUPS = eINSTANCE.getEnvironnement_ComponentNodeGroups();

		/**
		 * The meta object literal for the '<em><b>Engine Node Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONNEMENT__ENGINE_NODE_GROUPS = eINSTANCE.getEnvironnement_EngineNodeGroups();

		/**
		 * The meta object literal for the '<em><b>Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENVIRONNEMENT__PROFILE = eINSTANCE.getEnvironnement_Profile();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ConceptsImpl <em>Concepts</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ConceptsImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getConcepts()
		 * @generated
		 */
		EClass CONCEPTS = eINSTANCE.getConcepts();

		/**
		 * The meta object literal for the '<em><b>Component Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPTS__COMPONENT_TYPES = eINSTANCE.getConcepts_ComponentTypes();

		/**
		 * The meta object literal for the '<em><b>Engine Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPTS__ENGINE_TYPES = eINSTANCE.getConcepts_EngineTypes();

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
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.EngineGroupImpl <em>Engine Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.EngineGroupImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEngineGroup()
		 * @generated
		 */
		EClass ENGINE_GROUP = eINSTANCE.getEngineGroup();

		/**
		 * The meta object literal for the '<em><b>Engines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE_GROUP__ENGINES = eINSTANCE.getEngineGroup_Engines();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.EngineNodeGroupImpl <em>Engine Node Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.EngineNodeGroupImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getEngineNodeGroup()
		 * @generated
		 */
		EClass ENGINE_NODE_GROUP = eINSTANCE.getEngineNodeGroup();

		/**
		 * The meta object literal for the '<em><b>Engine Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE_NODE_GROUP__ENGINE_NODES = eINSTANCE.getEngineNodeGroup_EngineNodes();

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
		 * The meta object literal for the '<em><b>Version</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_ITEM__VERSION = eINSTANCE.getArchitectureItem_Version();

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
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCEPT_ITEM__VERSION = eINSTANCE.getConceptItem_Version();

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
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_ITEM__VERSION = eINSTANCE.getRuntimeItem_Version();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.ProjectImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Components Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__COMPONENTS_GROUPS = eINSTANCE.getProject_ComponentsGroups();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__COMPONENTS = eINSTANCE.getProject_Components();

		/**
		 * The meta object literal for the '<em><b>Engines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__ENGINES = eINSTANCE.getProject_Engines();

		/**
		 * The meta object literal for the '<em><b>Engine Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__ENGINE_GROUPS = eINSTANCE.getProject_EngineGroups();

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
		 * The meta object literal for the '<em><b>Tags</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_TAGS__TAGS = eINSTANCE.getHasTags_Tags();

		/**
		 * The meta object literal for the '<em><b>Tag Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_TAGS__TAG_GROUPS = eINSTANCE.getHasTags_TagGroups();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.TagImpl <em>Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.TagImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__VALUE = eINSTANCE.getTag_Value();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.core.impl.TagGroupImpl <em>Tag Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.impl.TagGroupImpl
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getTagGroup()
		 * @generated
		 */
		EClass TAG_GROUP = eINSTANCE.getTagGroup();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_GROUP__TAGS = eINSTANCE.getTagGroup_Tags();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_PROPERTY__NAME = eINSTANCE.getCustomProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_PROPERTY__DEFAULT_VALUE = eINSTANCE.getCustomProperty_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_PROPERTY__TYPE = eINSTANCE.getCustomProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_PROPERTY__VALUE = eINSTANCE.getCustomProperty_Value();

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
		 * The meta object literal for the '{@link org.m2ling.domain.core.CustomPropertyType <em>Custom Property Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.core.CustomPropertyType
		 * @see org.m2ling.domain.core.impl.CorePackageImpl#getCustomPropertyType()
		 * @generated
		 */
		EEnum CUSTOM_PROPERTY_TYPE = eINSTANCE.getCustomPropertyType();

	}

} //CorePackage
