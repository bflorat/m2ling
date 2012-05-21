/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.m2ling.domain.core.ComponentNode;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.impl.ComponentNodeImpl;

/**
 * This is the item provider adapter for a {@link org.m2ling.domain.core.ComponentNode} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ComponentNodeItemProvider extends ComponentNodeGroupItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ComponentNodeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addComponentPropertyDescriptor(object);
			addEngineNodePropertyDescriptor(object);
			addBoundComponentNodePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Component feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addComponentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComponentNode_component_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ComponentNode_component_feature", "_UI_ComponentNode_type"),
				 CorePackage.Literals.COMPONENT_NODE__COMPONENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Engine Node feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEngineNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComponentNode_engineNode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ComponentNode_engineNode_feature", "_UI_ComponentNode_type"),
				 CorePackage.Literals.COMPONENT_NODE__ENGINE_NODE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bound Component Node feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBoundComponentNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComponentNode_boundComponentNode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ComponentNode_boundComponentNode_feature", "_UI_ComponentNode_type"),
				 CorePackage.Literals.COMPONENT_NODE__BOUND_COMPONENT_NODE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
	 * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CorePackage.Literals.COMPONENT_NODE__SUB_NODES);
			childrenFeatures.add(CorePackage.Literals.COMPONENT_NODE__NODES);
			childrenFeatures.add(CorePackage.Literals.COMPONENT_NODE__STREAMS);
			childrenFeatures.add(CorePackage.Literals.COMPONENT_NODE__NODES_GROUPS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ComponentNode.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ComponentNode"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((ComponentNode) object).getName();
		ComponentNodeImpl comp = (ComponentNodeImpl) object;
		View view = null;
		EObject parent = comp.eContainer();
		while (!(parent instanceof View)) {
			parent = parent.eContainer();
		}
		view = (View) parent;
		return label == null || label.length() == 0 ? getString("_UI_ComponentNode_type")
				: getString("_UI_ComponentNode_type") + ": " + view.getName() + '#' + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ComponentNode.class)) {
			case CorePackage.COMPONENT_NODE__SUB_NODES:
			case CorePackage.COMPONENT_NODE__NODES:
			case CorePackage.COMPONENT_NODE__STREAMS:
			case CorePackage.COMPONENT_NODE__NODES_GROUPS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.COMPONENT_NODE__SUB_NODES,
				 CoreFactory.eINSTANCE.createComponentNode()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.COMPONENT_NODE__NODES,
				 CoreFactory.eINSTANCE.createComponentNode()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.COMPONENT_NODE__STREAMS,
				 CoreFactory.eINSTANCE.createNodesLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.COMPONENT_NODE__NODES_GROUPS,
				 CoreFactory.eINSTANCE.createComponentNodeGroup()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.COMPONENT_NODE__NODES_GROUPS,
				 CoreFactory.eINSTANCE.createComponentNode()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == CorePackage.Literals.COMPONENT_NODE__SUB_NODES ||
			childFeature == CorePackage.Literals.COMPONENT_NODE__NODES ||
			childFeature == CorePackage.Literals.COMPONENT_NODE__NODES_GROUPS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
