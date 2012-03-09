/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.m2ling.domain.core.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.core.CorePackage
 * @generated
 */
public class CoreAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CorePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreSwitch<Adapter> modelSwitch =
		new CoreSwitch<Adapter>() {
			@Override
			public Adapter caseEngineType(EngineType object) {
				return createEngineTypeAdapter();
			}
			@Override
			public Adapter caseComponentType(ComponentType object) {
				return createComponentTypeAdapter();
			}
			@Override
			public Adapter caseEngine(Engine object) {
				return createEngineAdapter();
			}
			@Override
			public Adapter caseComponent(Component object) {
				return createComponentAdapter();
			}
			@Override
			public Adapter caseHasName(HasName object) {
				return createHasNameAdapter();
			}
			@Override
			public Adapter caseEngineNode(EngineNode object) {
				return createEngineNodeAdapter();
			}
			@Override
			public Adapter caseComponentNode(ComponentNode object) {
				return createComponentNodeAdapter();
			}
			@Override
			public Adapter caseEnvironnement(Environnement object) {
				return createEnvironnementAdapter();
			}
			@Override
			public Adapter caseConcepts(Concepts object) {
				return createConceptsAdapter();
			}
			@Override
			public Adapter caseComponentGroup(ComponentGroup object) {
				return createComponentGroupAdapter();
			}
			@Override
			public Adapter caseEngineGroup(EngineGroup object) {
				return createEngineGroupAdapter();
			}
			@Override
			public Adapter caseEngineNodeGroup(EngineNodeGroup object) {
				return createEngineNodeGroupAdapter();
			}
			@Override
			public Adapter caseComponentNodeGroup(ComponentNodeGroup object) {
				return createComponentNodeGroupAdapter();
			}
			@Override
			public Adapter caseArchitectureItem(ArchitectureItem object) {
				return createArchitectureItemAdapter();
			}
			@Override
			public Adapter caseConceptItem(ConceptItem object) {
				return createConceptItemAdapter();
			}
			@Override
			public Adapter caseRuntimeItem(RuntimeItem object) {
				return createRuntimeItemAdapter();
			}
			@Override
			public Adapter caseProject(Project object) {
				return createProjectAdapter();
			}
			@Override
			public Adapter caseHasTags(HasTags object) {
				return createHasTagsAdapter();
			}
			@Override
			public Adapter caseTag(Tag object) {
				return createTagAdapter();
			}
			@Override
			public Adapter caseTagGroup(TagGroup object) {
				return createTagGroupAdapter();
			}
			@Override
			public Adapter caseHasComment(HasComment object) {
				return createHasCommentAdapter();
			}
			@Override
			public Adapter caseHasCustomProperties(HasCustomProperties object) {
				return createHasCustomPropertiesAdapter();
			}
			@Override
			public Adapter caseCustomProperty(CustomProperty object) {
				return createCustomPropertyAdapter();
			}
			@Override
			public Adapter caseLinkType(LinkType object) {
				return createLinkTypeAdapter();
			}
			@Override
			public Adapter caseLink(Link object) {
				return createLinkAdapter();
			}
			@Override
			public Adapter caseStream(Stream object) {
				return createStreamAdapter();
			}
			@Override
			public Adapter caseHasParameterDefinitions(HasParameterDefinitions object) {
				return createHasParameterDefinitionsAdapter();
			}
			@Override
			public Adapter caseHasParameterValues(HasParameterValues object) {
				return createHasParameterValuesAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.EngineType <em>Engine Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.EngineType
	 * @generated
	 */
	public Adapter createEngineTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.ComponentType
	 * @generated
	 */
	public Adapter createComponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.Engine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.Engine
	 * @generated
	 */
	public Adapter createEngineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.Component
	 * @generated
	 */
	public Adapter createComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasName <em>Has Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasName
	 * @generated
	 */
	public Adapter createHasNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.EngineNode <em>Engine Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.EngineNode
	 * @generated
	 */
	public Adapter createEngineNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.ComponentNode <em>Component Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.ComponentNode
	 * @generated
	 */
	public Adapter createComponentNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.Environnement <em>Environnement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.Environnement
	 * @generated
	 */
	public Adapter createEnvironnementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.Concepts <em>Concepts</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.Concepts
	 * @generated
	 */
	public Adapter createConceptsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.ComponentGroup <em>Component Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.ComponentGroup
	 * @generated
	 */
	public Adapter createComponentGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.EngineGroup <em>Engine Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.EngineGroup
	 * @generated
	 */
	public Adapter createEngineGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.EngineNodeGroup <em>Engine Node Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.EngineNodeGroup
	 * @generated
	 */
	public Adapter createEngineNodeGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.ComponentNodeGroup <em>Component Node Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.ComponentNodeGroup
	 * @generated
	 */
	public Adapter createComponentNodeGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.ArchitectureItem <em>Architecture Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.ArchitectureItem
	 * @generated
	 */
	public Adapter createArchitectureItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.ConceptItem <em>Concept Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.ConceptItem
	 * @generated
	 */
	public Adapter createConceptItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.RuntimeItem <em>Runtime Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.RuntimeItem
	 * @generated
	 */
	public Adapter createRuntimeItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.Project
	 * @generated
	 */
	public Adapter createProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasTags <em>Has Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasTags
	 * @generated
	 */
	public Adapter createHasTagsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.Tag
	 * @generated
	 */
	public Adapter createTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.TagGroup <em>Tag Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.TagGroup
	 * @generated
	 */
	public Adapter createTagGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasComment <em>Has Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasComment
	 * @generated
	 */
	public Adapter createHasCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasCustomProperties <em>Has Custom Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasCustomProperties
	 * @generated
	 */
	public Adapter createHasCustomPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.CustomProperty <em>Custom Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.CustomProperty
	 * @generated
	 */
	public Adapter createCustomPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.LinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.LinkType
	 * @generated
	 */
	public Adapter createLinkTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.Link
	 * @generated
	 */
	public Adapter createLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.Stream <em>Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.Stream
	 * @generated
	 */
	public Adapter createStreamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasParameterDefinitions <em>Has Parameter Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasParameterDefinitions
	 * @generated
	 */
	public Adapter createHasParameterDefinitionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasParameterValues <em>Has Parameter Values</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasParameterValues
	 * @generated
	 */
	public Adapter createHasParameterValuesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CoreAdapterFactory
