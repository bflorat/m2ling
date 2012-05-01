/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

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
import org.m2ling.domain.core.ViewPoint;

/**
 * This is the item provider adapter for a {@link org.m2ling.domain.core.ViewPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewPointItemProvider
	extends ConceptItemItemProvider
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
	public ViewPointItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addBaseViewpointPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Viewpoint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBaseViewpointPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ViewPoint_baseViewpoint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_baseViewpoint_feature", "_UI_ViewPoint_type"),
				 CorePackage.Literals.VIEW_POINT__BASE_VIEWPOINT,
				 true,
				 false,
				 true,
				 null,
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
				 getString("_UI_ViewPoint_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_name_feature", "_UI_ViewPoint_type"),
				 CorePackage.Literals.VIEW_POINT__NAME,
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
			childrenFeatures.add(CorePackage.Literals.VIEW_POINT__ACTIVITIES);
			childrenFeatures.add(CorePackage.Literals.VIEW_POINT__COMPONENT_TYPES);
			childrenFeatures.add(CorePackage.Literals.VIEW_POINT__LINK_TYPES);
			childrenFeatures.add(CorePackage.Literals.VIEW_POINT__RULES);
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
	 * This returns ViewPoint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ViewPoint"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ViewPoint)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ViewPoint_type") :
			getString("_UI_ViewPoint_type") + " " + label;
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

		switch (notification.getFeatureID(ViewPoint.class)) {
			case CorePackage.VIEW_POINT__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.VIEW_POINT__ACTIVITIES:
			case CorePackage.VIEW_POINT__COMPONENT_TYPES:
			case CorePackage.VIEW_POINT__LINK_TYPES:
			case CorePackage.VIEW_POINT__RULES:
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
				(CorePackage.Literals.VIEW_POINT__ACTIVITIES,
				 CoreFactory.eINSTANCE.createActivity()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.VIEW_POINT__COMPONENT_TYPES,
				 CoreFactory.eINSTANCE.createComponentType()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.VIEW_POINT__LINK_TYPES,
				 CoreFactory.eINSTANCE.createLinkType()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.VIEW_POINT__RULES,
				 CoreFactory.eINSTANCE.createRule()));
	}

}
