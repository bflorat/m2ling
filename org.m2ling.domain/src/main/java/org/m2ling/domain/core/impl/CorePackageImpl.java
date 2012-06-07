/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.m2ling.domain.DomainPackage;
import org.m2ling.domain.configuration.ConfigurationPackage;
import org.m2ling.domain.configuration.impl.ConfigurationPackageImpl;
import org.m2ling.domain.core.Activity;
import org.m2ling.domain.core.ActivityStatus;
import org.m2ling.domain.core.ActivityTransition;
import org.m2ling.domain.core.Actor;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.BoundaryConstraint;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentInstanceGroup;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.ConceptItem;
import org.m2ling.domain.core.Constraint;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.CustomProperty;
import org.m2ling.domain.core.CustomPropertyType;
import org.m2ling.domain.core.EMailConstraint;
import org.m2ling.domain.core.FloatConstraint;
import org.m2ling.domain.core.FormatConstraint;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasConstraints;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasLabel;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.HasParameterDefinitions;
import org.m2ling.domain.core.HasParameterValues;
import org.m2ling.domain.core.HasReferences;
import org.m2ling.domain.core.HasStatus;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.InstancesLink;
import org.m2ling.domain.core.IntegerConstraint;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkAccessType;
import org.m2ling.domain.core.LinkTemporality;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.MaxConstraint;
import org.m2ling.domain.core.MinConstraint;
import org.m2ling.domain.core.NotNullConstraint;
import org.m2ling.domain.core.OCLConstraint;
import org.m2ling.domain.core.OrganisationalUnit;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.ReferenceType;
import org.m2ling.domain.core.RegexpConstraint;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.RulePriority;
import org.m2ling.domain.core.RuntimeItem;
import org.m2ling.domain.core.Stakeholder;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.URLConstraint;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.domain.impl.DomainPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CorePackageImpl extends EPackageImpl implements CorePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasNameAndIDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentInstanceGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runtimeItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasTagsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasCustomPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instancesLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasParameterDefinitionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasParameterValuesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stakeholderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundaryConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notNullConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regexpConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maxConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMailConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formatConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasConstraintsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasReferencesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organisationalUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum customPropertyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum activityStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rulePriorityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum referenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum linkTemporalityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum linkAccessTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.m2ling.domain.core.CorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CorePackageImpl() {
		super(eNS_URI, CoreFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CorePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CorePackage init() {
		if (isInited) return (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Obtain or create and register package
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CorePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		ConfigurationPackageImpl theConfigurationPackage = (ConfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI) instanceof ConfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI) : ConfigurationPackage.eINSTANCE);

		// Create package meta-data objects
		theCorePackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theCorePackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCorePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CorePackage.eNS_URI, theCorePackage);
		return theCorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentType() {
		return componentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_EngineTypes() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Enumeration() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_InstantiationFactor() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Reifiable() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_References() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_BoundType() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Type() {
		return (EReference)componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_BoundComponent() {
		return (EReference)componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Instances() {
		return (EReference)componentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_References() {
		return (EReference)componentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentInstance() {
		return componentInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_Component() {
		return (EReference)componentInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_Instances() {
		return (EReference)componentInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_InstancesGroups() {
		return (EReference)componentInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_BoundComponentInstance() {
		return (EReference)componentInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_References() {
		return (EReference)componentInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasNameAndID() {
		return hasNameAndIDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHasNameAndID_Id() {
		return (EAttribute)hasNameAndIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHasNameAndID_Name() {
		return (EAttribute)hasNameAndIDEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewPoint() {
		return viewPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewPoint_ComponentTypes() {
		return (EReference)viewPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewPoint_Activities() {
		return (EReference)viewPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewPoint_LinkTypes() {
		return (EReference)viewPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewPoint_Rules() {
		return (EReference)viewPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentGroup() {
		return componentGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentGroup_Components() {
		return (EReference)componentGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentInstanceGroup() {
		return componentInstanceGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstanceGroup_ComponentInstances() {
		return (EReference)componentInstanceGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureItem() {
		return architectureItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptItem() {
		return conceptItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConceptItem_StatusLiterals() {
		return (EAttribute)conceptItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuntimeItem() {
		return runtimeItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuntimeItem_Status() {
		return (EAttribute)runtimeItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getView() {
		return viewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_ComponentsGroups() {
		return (EReference)viewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Components() {
		return (EReference)viewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_ViewPoint() {
		return (EReference)viewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Links() {
		return (EReference)viewEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Instances() {
		return (EReference)viewEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_InstancesGroups() {
		return (EReference)viewEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Streams() {
		return (EReference)viewEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasStatus() {
		return hasStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHasStatus_Status() {
		return (EAttribute)hasStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasTags() {
		return hasTagsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHasTags_Tags() {
		return (EAttribute)hasTagsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasComment() {
		return hasCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHasComment_Comment() {
		return (EAttribute)hasCommentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasCustomProperties() {
		return hasCustomPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHasCustomProperties_CustomProperties() {
		return (EReference)hasCustomPropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomProperty() {
		return customPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkType() {
		return linkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkType_SourceTypes() {
		return (EReference)linkTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkType_DestinationTypes() {
		return (EReference)linkTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_Reifiable() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_AccessType() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_Temporality() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Type() {
		return (EReference)linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Origins() {
		return (EReference)linkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Destinations() {
		return (EReference)linkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_TimeoutMillis() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstancesLink() {
		return instancesLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstancesLink_Source() {
		return (EReference)instancesLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstancesLink_Destination() {
		return (EReference)instancesLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstancesLink_Link() {
		return (EReference)instancesLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasParameterDefinitions() {
		return hasParameterDefinitionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasParameterValues() {
		return hasParameterValuesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStakeholder() {
		return stakeholderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStakeholder_Views() {
		return (EReference)stakeholderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStakeholder_ViewPoints() {
		return (EReference)stakeholderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStakeholder_Actors() {
		return (EReference)stakeholderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloatConstraint() {
		return floatConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMinConstraint() {
		return minConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundaryConstraint() {
		return boundaryConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundaryConstraint_Value() {
		return (EAttribute)boundaryConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundaryConstraint_Inclusive() {
		return (EAttribute)boundaryConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLConstraint() {
		return urlConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotNullConstraint() {
		return notNullConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegexpConstraint() {
		return regexpConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegexpConstraint_Regexp() {
		return (EAttribute)regexpConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLConstraint() {
		return oclConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOCLConstraint_Expression() {
		return (EAttribute)oclConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerConstraint() {
		return integerConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaxConstraint() {
		return maxConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMailConstraint() {
		return eMailConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormatConstraint() {
		return formatConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasConstraints() {
		return hasConstraintsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasReferences() {
		return hasReferencesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivity() {
		return activityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Responsibles() {
		return (EReference)activityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Accountables() {
		return (EReference)activityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivityTransition() {
		return activityTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityTransition_Date() {
		return (EAttribute)activityTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityTransition_FromStatus() {
		return (EAttribute)activityTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityTransition_ToStatus() {
		return (EAttribute)activityTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityTransition_Activity() {
		return (EReference)activityTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityTransition_Actor() {
		return (EReference)activityTransitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganisationalUnit() {
		return organisationalUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActor() {
		return actorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_Stakeholders() {
		return (EReference)actorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_Unit() {
		return (EReference)actorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActor_Username() {
		return (EAttribute)actorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActor_Admin() {
		return (EAttribute)actorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActor_PwdHash() {
		return (EAttribute)actorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActor_FirstName() {
		return (EAttribute)actorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActor_LastName() {
		return (EAttribute)actorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRule_Priority() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReference() {
		return referenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReference_Type() {
		return (EAttribute)referenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_Targets() {
		return (EReference)referenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasLabel() {
		return hasLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHasLabel_Label() {
		return (EAttribute)hasLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCustomPropertyType() {
		return customPropertyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActivityStatus() {
		return activityStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getType() {
		return typeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRulePriority() {
		return rulePriorityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReferenceType() {
		return referenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLinkTemporality() {
		return linkTemporalityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLinkAccessType() {
		return linkAccessTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactory getCoreFactory() {
		return (CoreFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		componentTypeEClass = createEClass(COMPONENT_TYPE);
		createEReference(componentTypeEClass, COMPONENT_TYPE__ENGINE_TYPES);
		createEReference(componentTypeEClass, COMPONENT_TYPE__BOUND_TYPE);
		createEReference(componentTypeEClass, COMPONENT_TYPE__ENUMERATION);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__INSTANTIATION_FACTOR);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__REIFIABLE);
		createEReference(componentTypeEClass, COMPONENT_TYPE__REFERENCES);

		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__TYPE);
		createEReference(componentEClass, COMPONENT__BOUND_COMPONENT);
		createEReference(componentEClass, COMPONENT__INSTANCES);
		createEReference(componentEClass, COMPONENT__REFERENCES);

		componentInstanceEClass = createEClass(COMPONENT_INSTANCE);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__COMPONENT);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__INSTANCES);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__INSTANCES_GROUPS);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__REFERENCES);

		viewPointEClass = createEClass(VIEW_POINT);
		createEReference(viewPointEClass, VIEW_POINT__ACTIVITIES);
		createEReference(viewPointEClass, VIEW_POINT__COMPONENT_TYPES);
		createEReference(viewPointEClass, VIEW_POINT__LINK_TYPES);
		createEReference(viewPointEClass, VIEW_POINT__RULES);

		componentGroupEClass = createEClass(COMPONENT_GROUP);
		createEReference(componentGroupEClass, COMPONENT_GROUP__COMPONENTS);

		componentInstanceGroupEClass = createEClass(COMPONENT_INSTANCE_GROUP);
		createEReference(componentInstanceGroupEClass, COMPONENT_INSTANCE_GROUP__COMPONENT_INSTANCES);

		architectureItemEClass = createEClass(ARCHITECTURE_ITEM);

		conceptItemEClass = createEClass(CONCEPT_ITEM);
		createEAttribute(conceptItemEClass, CONCEPT_ITEM__STATUS_LITERALS);

		runtimeItemEClass = createEClass(RUNTIME_ITEM);
		createEAttribute(runtimeItemEClass, RUNTIME_ITEM__STATUS);

		viewEClass = createEClass(VIEW);
		createEReference(viewEClass, VIEW__COMPONENTS_GROUPS);
		createEReference(viewEClass, VIEW__COMPONENTS);
		createEReference(viewEClass, VIEW__VIEW_POINT);
		createEReference(viewEClass, VIEW__LINKS);
		createEReference(viewEClass, VIEW__INSTANCES);
		createEReference(viewEClass, VIEW__INSTANCES_GROUPS);
		createEReference(viewEClass, VIEW__STREAMS);

		hasStatusEClass = createEClass(HAS_STATUS);
		createEAttribute(hasStatusEClass, HAS_STATUS__STATUS);

		hasNameAndIDEClass = createEClass(HAS_NAME_AND_ID);
		createEAttribute(hasNameAndIDEClass, HAS_NAME_AND_ID__ID);
		createEAttribute(hasNameAndIDEClass, HAS_NAME_AND_ID__NAME);

		hasTagsEClass = createEClass(HAS_TAGS);
		createEAttribute(hasTagsEClass, HAS_TAGS__TAGS);

		hasCommentEClass = createEClass(HAS_COMMENT);
		createEAttribute(hasCommentEClass, HAS_COMMENT__COMMENT);

		hasCustomPropertiesEClass = createEClass(HAS_CUSTOM_PROPERTIES);
		createEReference(hasCustomPropertiesEClass, HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES);

		hasParameterDefinitionsEClass = createEClass(HAS_PARAMETER_DEFINITIONS);

		hasParameterValuesEClass = createEClass(HAS_PARAMETER_VALUES);

		customPropertyEClass = createEClass(CUSTOM_PROPERTY);

		linkTypeEClass = createEClass(LINK_TYPE);
		createEReference(linkTypeEClass, LINK_TYPE__SOURCE_TYPES);
		createEReference(linkTypeEClass, LINK_TYPE__DESTINATION_TYPES);
		createEAttribute(linkTypeEClass, LINK_TYPE__REIFIABLE);
		createEAttribute(linkTypeEClass, LINK_TYPE__ACCESS_TYPE);
		createEAttribute(linkTypeEClass, LINK_TYPE__TEMPORALITY);

		linkEClass = createEClass(LINK);
		createEReference(linkEClass, LINK__TYPE);
		createEReference(linkEClass, LINK__ORIGINS);
		createEReference(linkEClass, LINK__DESTINATIONS);
		createEAttribute(linkEClass, LINK__TIMEOUT_MILLIS);

		instancesLinkEClass = createEClass(INSTANCES_LINK);
		createEReference(instancesLinkEClass, INSTANCES_LINK__SOURCE);
		createEReference(instancesLinkEClass, INSTANCES_LINK__DESTINATION);
		createEReference(instancesLinkEClass, INSTANCES_LINK__LINK);

		hasLabelEClass = createEClass(HAS_LABEL);
		createEAttribute(hasLabelEClass, HAS_LABEL__LABEL);

		stakeholderEClass = createEClass(STAKEHOLDER);
		createEReference(stakeholderEClass, STAKEHOLDER__VIEWS);
		createEReference(stakeholderEClass, STAKEHOLDER__VIEW_POINTS);
		createEReference(stakeholderEClass, STAKEHOLDER__ACTORS);

		constraintEClass = createEClass(CONSTRAINT);

		floatConstraintEClass = createEClass(FLOAT_CONSTRAINT);

		minConstraintEClass = createEClass(MIN_CONSTRAINT);

		boundaryConstraintEClass = createEClass(BOUNDARY_CONSTRAINT);
		createEAttribute(boundaryConstraintEClass, BOUNDARY_CONSTRAINT__VALUE);
		createEAttribute(boundaryConstraintEClass, BOUNDARY_CONSTRAINT__INCLUSIVE);

		urlConstraintEClass = createEClass(URL_CONSTRAINT);

		notNullConstraintEClass = createEClass(NOT_NULL_CONSTRAINT);

		regexpConstraintEClass = createEClass(REGEXP_CONSTRAINT);
		createEAttribute(regexpConstraintEClass, REGEXP_CONSTRAINT__REGEXP);

		oclConstraintEClass = createEClass(OCL_CONSTRAINT);
		createEAttribute(oclConstraintEClass, OCL_CONSTRAINT__EXPRESSION);

		integerConstraintEClass = createEClass(INTEGER_CONSTRAINT);

		maxConstraintEClass = createEClass(MAX_CONSTRAINT);

		eMailConstraintEClass = createEClass(EMAIL_CONSTRAINT);

		formatConstraintEClass = createEClass(FORMAT_CONSTRAINT);

		hasConstraintsEClass = createEClass(HAS_CONSTRAINTS);

		hasReferencesEClass = createEClass(HAS_REFERENCES);

		activityEClass = createEClass(ACTIVITY);
		createEReference(activityEClass, ACTIVITY__ACCOUNTABLES);
		createEReference(activityEClass, ACTIVITY__RESPONSIBLES);

		activityTransitionEClass = createEClass(ACTIVITY_TRANSITION);
		createEAttribute(activityTransitionEClass, ACTIVITY_TRANSITION__DATE);
		createEAttribute(activityTransitionEClass, ACTIVITY_TRANSITION__FROM_STATUS);
		createEAttribute(activityTransitionEClass, ACTIVITY_TRANSITION__TO_STATUS);
		createEReference(activityTransitionEClass, ACTIVITY_TRANSITION__ACTIVITY);
		createEReference(activityTransitionEClass, ACTIVITY_TRANSITION__ACTOR);

		organisationalUnitEClass = createEClass(ORGANISATIONAL_UNIT);

		actorEClass = createEClass(ACTOR);
		createEReference(actorEClass, ACTOR__STAKEHOLDERS);
		createEReference(actorEClass, ACTOR__UNIT);
		createEAttribute(actorEClass, ACTOR__USERNAME);
		createEAttribute(actorEClass, ACTOR__ADMIN);
		createEAttribute(actorEClass, ACTOR__PWD_HASH);
		createEAttribute(actorEClass, ACTOR__FIRST_NAME);
		createEAttribute(actorEClass, ACTOR__LAST_NAME);

		ruleEClass = createEClass(RULE);
		createEAttribute(ruleEClass, RULE__PRIORITY);

		referenceEClass = createEClass(REFERENCE);
		createEAttribute(referenceEClass, REFERENCE__TYPE);
		createEReference(referenceEClass, REFERENCE__TARGETS);

		// Create enums
		customPropertyTypeEEnum = createEEnum(CUSTOM_PROPERTY_TYPE);
		activityStatusEEnum = createEEnum(ACTIVITY_STATUS);
		typeEEnum = createEEnum(TYPE);
		rulePriorityEEnum = createEEnum(RULE_PRIORITY);
		referenceTypeEEnum = createEEnum(REFERENCE_TYPE);
		linkTemporalityEEnum = createEEnum(LINK_TEMPORALITY);
		linkAccessTypeEEnum = createEEnum(LINK_ACCESS_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		componentTypeEClass.getESuperTypes().add(this.getConceptItem());
		componentTypeEClass.getESuperTypes().add(this.getHasParameterDefinitions());
		componentTypeEClass.getESuperTypes().add(this.getHasReferences());
		componentEClass.getESuperTypes().add(this.getArchitectureItem());
		componentEClass.getESuperTypes().add(this.getHasParameterDefinitions());
		componentEClass.getESuperTypes().add(this.getHasReferences());
		componentInstanceEClass.getESuperTypes().add(this.getHasParameterValues());
		componentInstanceEClass.getESuperTypes().add(this.getRuntimeItem());
		componentInstanceEClass.getESuperTypes().add(this.getHasReferences());
		viewPointEClass.getESuperTypes().add(this.getConceptItem());
		componentGroupEClass.getESuperTypes().add(this.getArchitectureItem());
		componentGroupEClass.getESuperTypes().add(this.getHasParameterDefinitions());
		componentInstanceGroupEClass.getESuperTypes().add(this.getRuntimeItem());
		componentInstanceGroupEClass.getESuperTypes().add(this.getHasParameterValues());
		architectureItemEClass.getESuperTypes().add(this.getHasNameAndID());
		architectureItemEClass.getESuperTypes().add(this.getHasComment());
		architectureItemEClass.getESuperTypes().add(this.getHasTags());
		architectureItemEClass.getESuperTypes().add(this.getHasParameterDefinitions());
		architectureItemEClass.getESuperTypes().add(this.getHasConstraints());
		architectureItemEClass.getESuperTypes().add(this.getHasLabel());
		conceptItemEClass.getESuperTypes().add(this.getHasNameAndID());
		conceptItemEClass.getESuperTypes().add(this.getHasCustomProperties());
		conceptItemEClass.getESuperTypes().add(this.getHasComment());
		conceptItemEClass.getESuperTypes().add(this.getHasTags());
		conceptItemEClass.getESuperTypes().add(this.getHasParameterDefinitions());
		conceptItemEClass.getESuperTypes().add(this.getHasConstraints());
		conceptItemEClass.getESuperTypes().add(this.getHasLabel());
		runtimeItemEClass.getESuperTypes().add(this.getHasNameAndID());
		runtimeItemEClass.getESuperTypes().add(this.getHasComment());
		runtimeItemEClass.getESuperTypes().add(this.getHasTags());
		runtimeItemEClass.getESuperTypes().add(this.getHasParameterValues());
		runtimeItemEClass.getESuperTypes().add(this.getHasConstraints());
		runtimeItemEClass.getESuperTypes().add(this.getHasLabel());
		viewEClass.getESuperTypes().add(this.getArchitectureItem());
		linkTypeEClass.getESuperTypes().add(this.getConceptItem());
		linkEClass.getESuperTypes().add(this.getArchitectureItem());
		instancesLinkEClass.getESuperTypes().add(this.getRuntimeItem());
		stakeholderEClass.getESuperTypes().add(this.getHasNameAndID());
		stakeholderEClass.getESuperTypes().add(this.getHasLabel());
		floatConstraintEClass.getESuperTypes().add(this.getConstraint());
		minConstraintEClass.getESuperTypes().add(this.getBoundaryConstraint());
		boundaryConstraintEClass.getESuperTypes().add(this.getConstraint());
		urlConstraintEClass.getESuperTypes().add(this.getConstraint());
		notNullConstraintEClass.getESuperTypes().add(this.getConstraint());
		regexpConstraintEClass.getESuperTypes().add(this.getConstraint());
		oclConstraintEClass.getESuperTypes().add(this.getConstraint());
		integerConstraintEClass.getESuperTypes().add(this.getConstraint());
		maxConstraintEClass.getESuperTypes().add(this.getBoundaryConstraint());
		eMailConstraintEClass.getESuperTypes().add(this.getConstraint());
		formatConstraintEClass.getESuperTypes().add(this.getConstraint());
		activityEClass.getESuperTypes().add(this.getHasNameAndID());
		activityEClass.getESuperTypes().add(this.getHasTags());
		activityEClass.getESuperTypes().add(this.getHasLabel());
		activityTransitionEClass.getESuperTypes().add(this.getHasComment());
		activityTransitionEClass.getESuperTypes().add(this.getHasLabel());
		organisationalUnitEClass.getESuperTypes().add(this.getHasComment());
		organisationalUnitEClass.getESuperTypes().add(this.getHasCustomProperties());
		organisationalUnitEClass.getESuperTypes().add(this.getHasNameAndID());
		organisationalUnitEClass.getESuperTypes().add(this.getHasTags());
		organisationalUnitEClass.getESuperTypes().add(this.getHasLabel());
		actorEClass.getESuperTypes().add(this.getHasCustomProperties());
		actorEClass.getESuperTypes().add(this.getHasTags());
		actorEClass.getESuperTypes().add(this.getHasLabel());
		ruleEClass.getESuperTypes().add(this.getHasNameAndID());
		ruleEClass.getESuperTypes().add(this.getHasCustomProperties());
		ruleEClass.getESuperTypes().add(this.getHasComment());
		ruleEClass.getESuperTypes().add(this.getHasTags());
		ruleEClass.getESuperTypes().add(this.getHasLabel());
		ruleEClass.getESuperTypes().add(this.getHasStatus());
		referenceEClass.getESuperTypes().add(this.getHasComment());
		referenceEClass.getESuperTypes().add(this.getHasConstraints());
		referenceEClass.getESuperTypes().add(this.getHasCustomProperties());
		referenceEClass.getESuperTypes().add(this.getHasLabel());
		referenceEClass.getESuperTypes().add(this.getHasStatus());
		referenceEClass.getESuperTypes().add(this.getHasTags());

		// Initialize classes and features; add operations and parameters
		initEClass(componentTypeEClass, ComponentType.class, "ComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentType_EngineTypes(), this.getComponentType(), null, "engineTypes", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentType_BoundType(), this.getComponentType(), null, "boundType", null, 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentType_Enumeration(), this.getComponentGroup(), null, "enumeration", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_InstantiationFactor(), ecorePackage.getEInt(), "instantiationFactor", "1", 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_Reifiable(), ecorePackage.getEBoolean(), "reifiable", "false", 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentType_References(), this.getReference(), null, "references", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_Type(), this.getComponentType(), null, "type", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_BoundComponent(), this.getComponent(), null, "boundComponent", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Instances(), this.getComponentInstance(), null, "instances", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_References(), this.getReference(), null, "references", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentInstanceEClass, ComponentInstance.class, "ComponentInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentInstance_Component(), this.getComponent(), null, "component", null, 1, 1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentInstance_Instances(), this.getComponentInstance(), null, "instances", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentInstance_InstancesGroups(), this.getComponentInstanceGroup(), null, "instancesGroups", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentInstance_BoundComponentInstance(), this.getComponentInstance(), null, "boundComponentInstance", null, 0, 1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentInstance_References(), this.getReference(), null, "references", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewPointEClass, ViewPoint.class, "ViewPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewPoint_Activities(), this.getActivity(), null, "activities", null, 0, -1, ViewPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViewPoint_ComponentTypes(), this.getComponentType(), null, "componentTypes", null, 0, -1, ViewPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViewPoint_LinkTypes(), this.getLinkType(), null, "linkTypes", null, 0, -1, ViewPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViewPoint_Rules(), this.getRule(), null, "rules", null, 0, -1, ViewPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentGroupEClass, ComponentGroup.class, "ComponentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentGroup_Components(), this.getComponent(), null, "components", null, 0, -1, ComponentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentInstanceGroupEClass, ComponentInstanceGroup.class, "ComponentInstanceGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentInstanceGroup_ComponentInstances(), this.getComponentInstance(), null, "componentInstances", null, 0, -1, ComponentInstanceGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureItemEClass, ArchitectureItem.class, "ArchitectureItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptItemEClass, ConceptItem.class, "ConceptItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConceptItem_StatusLiterals(), ecorePackage.getEString(), "statusLiterals", null, 1, -1, ConceptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runtimeItemEClass, RuntimeItem.class, "RuntimeItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuntimeItem_Status(), ecorePackage.getEString(), "status", null, 0, 1, RuntimeItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getView_ComponentsGroups(), this.getComponentGroup(), null, "componentsGroups", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_Components(), this.getComponent(), null, "components", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getView_Components().getEKeys().add(this.getHasNameAndID_Id());
		initEReference(getView_ViewPoint(), this.getViewPoint(), null, "viewPoint", null, 1, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_Links(), this.getLink(), null, "links", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getView_Links().getEKeys().add(this.getHasNameAndID_Id());
		initEReference(getView_Instances(), this.getComponentInstance(), null, "instances", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_InstancesGroups(), this.getComponentInstanceGroup(), null, "instancesGroups", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_Streams(), this.getInstancesLink(), null, "streams", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hasStatusEClass, HasStatus.class, "HasStatus", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHasStatus_Status(), ecorePackage.getEString(), "status", null, 0, 1, HasStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hasNameAndIDEClass, HasNameAndID.class, "HasNameAndID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHasNameAndID_Id(), ecorePackage.getEString(), "id", "", 0, 1, HasNameAndID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHasNameAndID_Name(), ecorePackage.getEString(), "name", null, 0, 1, HasNameAndID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hasTagsEClass, HasTags.class, "HasTags", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHasTags_Tags(), ecorePackage.getEString(), "tags", "", 0, -1, HasTags.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hasCommentEClass, HasComment.class, "HasComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHasComment_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, HasComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hasCustomPropertiesEClass, HasCustomProperties.class, "HasCustomProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHasCustomProperties_CustomProperties(), this.getCustomProperty(), null, "customProperties", null, 0, 1, HasCustomProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hasParameterDefinitionsEClass, HasParameterDefinitions.class, "HasParameterDefinitions", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hasParameterValuesEClass, HasParameterValues.class, "HasParameterValues", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(customPropertyEClass, CustomProperty.class, "CustomProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linkTypeEClass, LinkType.class, "LinkType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkType_SourceTypes(), this.getComponentType(), null, "sourceTypes", null, 1, -1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkType_DestinationTypes(), this.getComponentType(), null, "destinationTypes", null, 1, -1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_Reifiable(), ecorePackage.getEBoolean(), "reifiable", "false", 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_AccessType(), this.getLinkAccessType(), "accessType", null, 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_Temporality(), this.getLinkTemporality(), "temporality", null, 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLink_Type(), this.getLinkType(), null, "type", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLink_Origins(), this.getComponent(), null, "origins", null, 1, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLink_Destinations(), this.getComponent(), null, "destinations", null, 1, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_TimeoutMillis(), ecorePackage.getELong(), "timeoutMillis", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instancesLinkEClass, InstancesLink.class, "InstancesLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstancesLink_Source(), this.getComponentInstance(), null, "source", null, 1, 1, InstancesLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstancesLink_Destination(), this.getComponentInstance(), null, "destination", null, 1, 1, InstancesLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstancesLink_Link(), this.getLink(), null, "link", null, 1, 1, InstancesLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hasLabelEClass, HasLabel.class, "HasLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHasLabel_Label(), ecorePackage.getEString(), "label", null, 0, 1, HasLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stakeholderEClass, Stakeholder.class, "Stakeholder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStakeholder_Views(), this.getView(), null, "views", null, 0, -1, Stakeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStakeholder_ViewPoints(), this.getViewPoint(), null, "viewPoints", null, 0, -1, Stakeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStakeholder_Actors(), this.getActor(), this.getActor_Stakeholders(), "actors", null, 0, -1, Stakeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(floatConstraintEClass, FloatConstraint.class, "FloatConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(minConstraintEClass, MinConstraint.class, "MinConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boundaryConstraintEClass, BoundaryConstraint.class, "BoundaryConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoundaryConstraint_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, BoundaryConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundaryConstraint_Inclusive(), ecorePackage.getEBoolean(), "inclusive", null, 0, 1, BoundaryConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(urlConstraintEClass, URLConstraint.class, "URLConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notNullConstraintEClass, NotNullConstraint.class, "NotNullConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regexpConstraintEClass, RegexpConstraint.class, "RegexpConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegexpConstraint_Regexp(), ecorePackage.getEString(), "regexp", null, 0, 1, RegexpConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclConstraintEClass, OCLConstraint.class, "OCLConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOCLConstraint_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, OCLConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerConstraintEClass, IntegerConstraint.class, "IntegerConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(maxConstraintEClass, MaxConstraint.class, "MaxConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eMailConstraintEClass, EMailConstraint.class, "EMailConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(formatConstraintEClass, FormatConstraint.class, "FormatConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hasConstraintsEClass, HasConstraints.class, "HasConstraints", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hasReferencesEClass, HasReferences.class, "HasReferences", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(activityEClass, Activity.class, "Activity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivity_Accountables(), this.getStakeholder(), null, "accountables", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_Responsibles(), this.getStakeholder(), null, "responsibles", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activityTransitionEClass, ActivityTransition.class, "ActivityTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivityTransition_Date(), ecorePackage.getELong(), "date", null, 0, 1, ActivityTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityTransition_FromStatus(), this.getActivityStatus(), "fromStatus", null, 0, 1, ActivityTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityTransition_ToStatus(), this.getActivityStatus(), "toStatus", null, 0, 1, ActivityTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivityTransition_Activity(), this.getActivity(), null, "activity", null, 1, 1, ActivityTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivityTransition_Actor(), this.getActor(), null, "actor", null, 0, -1, ActivityTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(organisationalUnitEClass, OrganisationalUnit.class, "OrganisationalUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actorEClass, Actor.class, "Actor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActor_Stakeholders(), this.getStakeholder(), this.getStakeholder_Actors(), "stakeholders", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActor_Unit(), this.getOrganisationalUnit(), null, "unit", null, 1, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActor_Username(), ecorePackage.getEString(), "username", null, 0, 1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActor_Admin(), ecorePackage.getEBoolean(), "admin", null, 0, 1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActor_PwdHash(), ecorePackage.getEString(), "pwdHash", null, 0, 1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActor_FirstName(), ecorePackage.getEString(), "firstName", null, 0, 1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActor_LastName(), ecorePackage.getEString(), "lastName", null, 0, 1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRule_Priority(), this.getRulePriority(), "priority", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReference_Type(), this.getReferenceType(), "type", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReference_Targets(), this.getHasReferences(), null, "targets", null, 0, -1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(customPropertyTypeEEnum, CustomPropertyType.class, "CustomPropertyType");

		initEEnum(activityStatusEEnum, ActivityStatus.class, "ActivityStatus");
		addEEnumLiteral(activityStatusEEnum, ActivityStatus.TODO);
		addEEnumLiteral(activityStatusEEnum, ActivityStatus.CANCELED);
		addEEnumLiteral(activityStatusEEnum, ActivityStatus.VALIDATED);
		addEEnumLiteral(activityStatusEEnum, ActivityStatus.WAITING_FOR_VALIDATION);

		initEEnum(typeEEnum, Type.class, "Type");
		addEEnumLiteral(typeEEnum, Type.COMPONENT_TYPE);
		addEEnumLiteral(typeEEnum, Type.LINK_TYPE);
		addEEnumLiteral(typeEEnum, Type.COMPONENT);
		addEEnumLiteral(typeEEnum, Type.LINK);
		addEEnumLiteral(typeEEnum, Type.COMPONENT_NODE);
		addEEnumLiteral(typeEEnum, Type.STREAM);
		addEEnumLiteral(typeEEnum, Type.VIEWPOINT);
		addEEnumLiteral(typeEEnum, Type.VIEW);

		initEEnum(rulePriorityEEnum, RulePriority.class, "RulePriority");
		addEEnumLiteral(rulePriorityEEnum, RulePriority.VERY_LOW);
		addEEnumLiteral(rulePriorityEEnum, RulePriority.LOW);
		addEEnumLiteral(rulePriorityEEnum, RulePriority.MEDIUM);
		addEEnumLiteral(rulePriorityEEnum, RulePriority.HIGH);
		addEEnumLiteral(rulePriorityEEnum, RulePriority.VERY_HIGH);

		initEEnum(referenceTypeEEnum, ReferenceType.class, "ReferenceType");
		addEEnumLiteral(referenceTypeEEnum, ReferenceType.CONTAINS);
		addEEnumLiteral(referenceTypeEEnum, ReferenceType.RUNS);
		addEEnumLiteral(referenceTypeEEnum, ReferenceType.DEPENDS_ON);
		addEEnumLiteral(referenceTypeEEnum, ReferenceType.ADMINS);

		initEEnum(linkTemporalityEEnum, LinkTemporality.class, "LinkTemporality");
		addEEnumLiteral(linkTemporalityEEnum, LinkTemporality.SYNC);
		addEEnumLiteral(linkTemporalityEEnum, LinkTemporality.ASYNC_PULL);
		addEEnumLiteral(linkTemporalityEEnum, LinkTemporality.ASYNC_PUSH);

		initEEnum(linkAccessTypeEEnum, LinkAccessType.class, "LinkAccessType");
		addEEnumLiteral(linkAccessTypeEEnum, LinkAccessType.CREATE);
		addEEnumLiteral(linkAccessTypeEEnum, LinkAccessType.READ);
		addEEnumLiteral(linkAccessTypeEEnum, LinkAccessType.UPDATE);
		addEEnumLiteral(linkAccessTypeEEnum, LinkAccessType.DELETE);
		addEEnumLiteral(linkAccessTypeEEnum, LinkAccessType.RW);
		addEEnumLiteral(linkAccessTypeEEnum, LinkAccessType.RO);
		addEEnumLiteral(linkAccessTypeEEnum, LinkAccessType.SEARCH);
		addEEnumLiteral(linkAccessTypeEEnum, LinkAccessType.SEARCH_INDEX_OUTPUT);
		addEEnumLiteral(linkAccessTypeEEnum, LinkAccessType.EVENT);
	}

} //CorePackageImpl
