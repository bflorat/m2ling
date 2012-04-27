/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.parameters.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.CorePackage;

import org.m2ling.domain.core.provider.HasCommentItemProvider;

import org.m2ling.domain.parameters.ParameterDefinition;
import org.m2ling.domain.parameters.ParametersFactory;
import org.m2ling.domain.parameters.ParametersPackage;

import org.m2ling.domain.provider.M2lingEditPlugin;

/**
 * This is the item provider adapter for a {@link org.m2ling.domain.parameters.ParameterDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ParameterDefinitionItemProvider
	extends HasCommentItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDefinitionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCustomPropertiesPropertyDescriptor(object);
			addIDPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addParentPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addDefaultValuePropertyDescriptor(object);
			addExampleValuePropertyDescriptor(object);
			addDerivationExpressionPropertyDescriptor(object);
			addLongDescriptionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Custom Properties feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCustomPropertiesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HasCustomProperties_customProperties_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HasCustomProperties_customProperties_feature", "_UI_HasCustomProperties_type"),
				 CorePackage.Literals.HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HasNameAndID_iD_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HasNameAndID_iD_feature", "_UI_HasNameAndID_type"),
				 CorePackage.Literals.HAS_NAME_AND_ID__ID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HasNameAndID_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HasNameAndID_name_feature", "_UI_HasNameAndID_type"),
				 CorePackage.Literals.HAS_NAME_AND_ID__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ParameterDefinition_parent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParameterDefinition_parent_feature", "_UI_ParameterDefinition_type"),
				 ParametersPackage.Literals.PARAMETER_DEFINITION__PARENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ParameterDefinition_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParameterDefinition_type_feature", "_UI_ParameterDefinition_type"),
				 ParametersPackage.Literals.PARAMETER_DEFINITION__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ParameterDefinition_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParameterDefinition_description_feature", "_UI_ParameterDefinition_type"),
				 ParametersPackage.Literals.PARAMETER_DEFINITION__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ParameterDefinition_defaultValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParameterDefinition_defaultValue_feature", "_UI_ParameterDefinition_type"),
				 ParametersPackage.Literals.PARAMETER_DEFINITION__DEFAULT_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Example Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExampleValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ParameterDefinition_exampleValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParameterDefinition_exampleValue_feature", "_UI_ParameterDefinition_type"),
				 ParametersPackage.Literals.PARAMETER_DEFINITION__EXAMPLE_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Derivation Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDerivationExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ParameterDefinition_derivationExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParameterDefinition_derivationExpression_feature", "_UI_ParameterDefinition_type"),
				 ParametersPackage.Literals.PARAMETER_DEFINITION__DERIVATION_EXPRESSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Long Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLongDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ParameterDefinition_longDescription_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParameterDefinition_longDescription_feature", "_UI_ParameterDefinition_type"),
				 ParametersPackage.Literals.PARAMETER_DEFINITION__LONG_DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS);
			childrenFeatures.add(ParametersPackage.Literals.PARAMETER_DEFINITION__OVERRIDERS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ParameterDefinition)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ParameterDefinition_type") :
			getString("_UI_ParameterDefinition_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ParameterDefinition.class)) {
			case ParametersPackage.PARAMETER_DEFINITION__ID:
			case ParametersPackage.PARAMETER_DEFINITION__NAME:
			case ParametersPackage.PARAMETER_DEFINITION__TYPE:
			case ParametersPackage.PARAMETER_DEFINITION__DESCRIPTION:
			case ParametersPackage.PARAMETER_DEFINITION__DEFAULT_VALUE:
			case ParametersPackage.PARAMETER_DEFINITION__EXAMPLE_VALUE:
			case ParametersPackage.PARAMETER_DEFINITION__DERIVATION_EXPRESSION:
			case ParametersPackage.PARAMETER_DEFINITION__LONG_DESCRIPTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ParametersPackage.PARAMETER_DEFINITION__CONSTRAINTS:
			case ParametersPackage.PARAMETER_DEFINITION__OVERRIDERS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS,
				 CoreFactory.eINSTANCE.createFloatConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS,
				 CoreFactory.eINSTANCE.createMinConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS,
				 CoreFactory.eINSTANCE.createURLConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS,
				 CoreFactory.eINSTANCE.createNotNullConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS,
				 CoreFactory.eINSTANCE.createRegexpConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS,
				 CoreFactory.eINSTANCE.createOCLConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS,
				 CoreFactory.eINSTANCE.createIntegerConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS,
				 CoreFactory.eINSTANCE.createMaxConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS,
				 CoreFactory.eINSTANCE.createEMailConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__CONSTRAINTS,
				 CoreFactory.eINSTANCE.createFormatConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ParametersPackage.Literals.PARAMETER_DEFINITION__OVERRIDERS,
				 ParametersFactory.eINSTANCE.createParamDefOverrider()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return M2lingEditPlugin.INSTANCE;
	}

}
