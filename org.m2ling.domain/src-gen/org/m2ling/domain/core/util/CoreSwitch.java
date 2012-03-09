/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.m2ling.domain.core.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.core.CorePackage
 * @generated
 */
public class CoreSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreSwitch() {
		if (modelPackage == null) {
			modelPackage = CorePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CorePackage.ENGINE_TYPE: {
				EngineType engineType = (EngineType)theEObject;
				T result = caseEngineType(engineType);
				if (result == null) result = caseConceptItem(engineType);
				if (result == null) result = caseHasName(engineType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT_TYPE: {
				ComponentType componentType = (ComponentType)theEObject;
				T result = caseComponentType(componentType);
				if (result == null) result = caseConceptItem(componentType);
				if (result == null) result = caseHasName(componentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ENGINE: {
				Engine engine = (Engine)theEObject;
				T result = caseEngine(engine);
				if (result == null) result = caseEngineGroup(engine);
				if (result == null) result = caseArchitectureItem(engine);
				if (result == null) result = caseHasName(engine);
				if (result == null) result = caseHasParameterDefinitions(engine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = caseComponentGroup(component);
				if (result == null) result = caseArchitectureItem(component);
				if (result == null) result = caseHasName(component);
				if (result == null) result = caseHasParameterDefinitions(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_NAME: {
				HasName hasName = (HasName)theEObject;
				T result = caseHasName(hasName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ENGINE_NODE: {
				EngineNode engineNode = (EngineNode)theEObject;
				T result = caseEngineNode(engineNode);
				if (result == null) result = caseEngineNodeGroup(engineNode);
				if (result == null) result = caseRuntimeItem(engineNode);
				if (result == null) result = caseHasName(engineNode);
				if (result == null) result = caseHasParameterValues(engineNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT_NODE: {
				ComponentNode componentNode = (ComponentNode)theEObject;
				T result = caseComponentNode(componentNode);
				if (result == null) result = caseComponentNodeGroup(componentNode);
				if (result == null) result = caseRuntimeItem(componentNode);
				if (result == null) result = caseHasName(componentNode);
				if (result == null) result = caseHasParameterValues(componentNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ENVIRONNEMENT: {
				Environnement environnement = (Environnement)theEObject;
				T result = caseEnvironnement(environnement);
				if (result == null) result = caseRuntimeItem(environnement);
				if (result == null) result = caseHasName(environnement);
				if (result == null) result = caseHasParameterValues(environnement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONCEPTS: {
				Concepts concepts = (Concepts)theEObject;
				T result = caseConcepts(concepts);
				if (result == null) result = caseConceptItem(concepts);
				if (result == null) result = caseHasName(concepts);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT_GROUP: {
				ComponentGroup componentGroup = (ComponentGroup)theEObject;
				T result = caseComponentGroup(componentGroup);
				if (result == null) result = caseArchitectureItem(componentGroup);
				if (result == null) result = caseHasName(componentGroup);
				if (result == null) result = caseHasParameterDefinitions(componentGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ENGINE_GROUP: {
				EngineGroup engineGroup = (EngineGroup)theEObject;
				T result = caseEngineGroup(engineGroup);
				if (result == null) result = caseArchitectureItem(engineGroup);
				if (result == null) result = caseHasName(engineGroup);
				if (result == null) result = caseHasParameterDefinitions(engineGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ENGINE_NODE_GROUP: {
				EngineNodeGroup engineNodeGroup = (EngineNodeGroup)theEObject;
				T result = caseEngineNodeGroup(engineNodeGroup);
				if (result == null) result = caseRuntimeItem(engineNodeGroup);
				if (result == null) result = caseHasName(engineNodeGroup);
				if (result == null) result = caseHasParameterValues(engineNodeGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT_NODE_GROUP: {
				ComponentNodeGroup componentNodeGroup = (ComponentNodeGroup)theEObject;
				T result = caseComponentNodeGroup(componentNodeGroup);
				if (result == null) result = caseRuntimeItem(componentNodeGroup);
				if (result == null) result = caseHasName(componentNodeGroup);
				if (result == null) result = caseHasParameterValues(componentNodeGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ARCHITECTURE_ITEM: {
				ArchitectureItem architectureItem = (ArchitectureItem)theEObject;
				T result = caseArchitectureItem(architectureItem);
				if (result == null) result = caseHasName(architectureItem);
				if (result == null) result = caseHasParameterDefinitions(architectureItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONCEPT_ITEM: {
				ConceptItem conceptItem = (ConceptItem)theEObject;
				T result = caseConceptItem(conceptItem);
				if (result == null) result = caseHasName(conceptItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.RUNTIME_ITEM: {
				RuntimeItem runtimeItem = (RuntimeItem)theEObject;
				T result = caseRuntimeItem(runtimeItem);
				if (result == null) result = caseHasName(runtimeItem);
				if (result == null) result = caseHasParameterValues(runtimeItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PROJECT: {
				Project project = (Project)theEObject;
				T result = caseProject(project);
				if (result == null) result = caseArchitectureItem(project);
				if (result == null) result = caseHasName(project);
				if (result == null) result = caseHasParameterDefinitions(project);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_TAGS: {
				HasTags hasTags = (HasTags)theEObject;
				T result = caseHasTags(hasTags);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.TAG: {
				Tag tag = (Tag)theEObject;
				T result = caseTag(tag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.TAG_GROUP: {
				TagGroup tagGroup = (TagGroup)theEObject;
				T result = caseTagGroup(tagGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_COMMENT: {
				HasComment hasComment = (HasComment)theEObject;
				T result = caseHasComment(hasComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_CUSTOM_PROPERTIES: {
				HasCustomProperties hasCustomProperties = (HasCustomProperties)theEObject;
				T result = caseHasCustomProperties(hasCustomProperties);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CUSTOM_PROPERTY: {
				CustomProperty customProperty = (CustomProperty)theEObject;
				T result = caseCustomProperty(customProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.LINK_TYPE: {
				LinkType linkType = (LinkType)theEObject;
				T result = caseLinkType(linkType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.LINK: {
				Link link = (Link)theEObject;
				T result = caseLink(link);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.STREAM: {
				Stream stream = (Stream)theEObject;
				T result = caseStream(stream);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_PARAMETER_DEFINITIONS: {
				HasParameterDefinitions hasParameterDefinitions = (HasParameterDefinitions)theEObject;
				T result = caseHasParameterDefinitions(hasParameterDefinitions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_PARAMETER_VALUES: {
				HasParameterValues hasParameterValues = (HasParameterValues)theEObject;
				T result = caseHasParameterValues(hasParameterValues);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Engine Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Engine Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEngineType(EngineType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentType(ComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Engine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Engine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEngine(Engine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasName(HasName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Engine Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Engine Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEngineNode(EngineNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentNode(ComponentNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Environnement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Environnement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnvironnement(Environnement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concepts</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concepts</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcepts(Concepts object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentGroup(ComponentGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Engine Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Engine Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEngineGroup(EngineGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Engine Node Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Engine Node Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEngineNodeGroup(EngineNodeGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Node Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Node Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentNodeGroup(ComponentNodeGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Architecture Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Architecture Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArchitectureItem(ArchitectureItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptItem(ConceptItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Runtime Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Runtime Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuntimeItem(RuntimeItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProject(Project object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Tags</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Tags</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasTags(HasTags object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTag(Tag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagGroup(TagGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasComment(HasComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Custom Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Custom Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasCustomProperties(HasCustomProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomProperty(CustomProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkType(LinkType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLink(Link object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stream</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stream</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStream(Stream object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Parameter Definitions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Parameter Definitions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasParameterDefinitions(HasParameterDefinitions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Parameter Values</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Parameter Values</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasParameterValues(HasParameterValues object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CoreSwitch
