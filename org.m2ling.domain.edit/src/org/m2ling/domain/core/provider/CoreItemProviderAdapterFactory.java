/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.core.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.m2ling.domain.core.util.CoreAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreItemProviderAdapterFactory extends CoreAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.ComponentType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentTypeItemProvider componentTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComponentTypeAdapter() {
		if (componentTypeItemProvider == null) {
			componentTypeItemProvider = new ComponentTypeItemProvider(this);
		}

		return componentTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.Component} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentItemProvider componentItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.Component}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComponentAdapter() {
		if (componentItemProvider == null) {
			componentItemProvider = new ComponentItemProvider(this);
		}

		return componentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.ComponentNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentNodeItemProvider componentNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.ComponentNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComponentNodeAdapter() {
		if (componentNodeItemProvider == null) {
			componentNodeItemProvider = new ComponentNodeItemProvider(this);
		}

		return componentNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.ViewPoint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewPointItemProvider viewPointItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.ViewPoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createViewPointAdapter() {
		if (viewPointItemProvider == null) {
			viewPointItemProvider = new ViewPointItemProvider(this);
		}

		return viewPointItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.ComponentGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentGroupItemProvider componentGroupItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.ComponentGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComponentGroupAdapter() {
		if (componentGroupItemProvider == null) {
			componentGroupItemProvider = new ComponentGroupItemProvider(this);
		}

		return componentGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.ComponentNodeGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentNodeGroupItemProvider componentNodeGroupItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.ComponentNodeGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComponentNodeGroupAdapter() {
		if (componentNodeGroupItemProvider == null) {
			componentNodeGroupItemProvider = new ComponentNodeGroupItemProvider(this);
		}

		return componentNodeGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.View} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewItemProvider viewItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.View}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createViewAdapter() {
		if (viewItemProvider == null) {
			viewItemProvider = new ViewItemProvider(this);
		}

		return viewItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.HasComment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HasCommentItemProvider hasCommentItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.HasComment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHasCommentAdapter() {
		if (hasCommentItemProvider == null) {
			hasCommentItemProvider = new HasCommentItemProvider(this);
		}

		return hasCommentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.HasCustomProperties} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HasCustomPropertiesItemProvider hasCustomPropertiesItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.HasCustomProperties}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHasCustomPropertiesAdapter() {
		if (hasCustomPropertiesItemProvider == null) {
			hasCustomPropertiesItemProvider = new HasCustomPropertiesItemProvider(this);
		}

		return hasCustomPropertiesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.CustomProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomPropertyItemProvider customPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.CustomProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCustomPropertyAdapter() {
		if (customPropertyItemProvider == null) {
			customPropertyItemProvider = new CustomPropertyItemProvider(this);
		}

		return customPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.LinkType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkTypeItemProvider linkTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.LinkType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLinkTypeAdapter() {
		if (linkTypeItemProvider == null) {
			linkTypeItemProvider = new LinkTypeItemProvider(this);
		}

		return linkTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.Link} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkItemProvider linkItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.Link}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLinkAdapter() {
		if (linkItemProvider == null) {
			linkItemProvider = new LinkItemProvider(this);
		}

		return linkItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.Stream} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StreamItemProvider streamItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.Stream}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStreamAdapter() {
		if (streamItemProvider == null) {
			streamItemProvider = new StreamItemProvider(this);
		}

		return streamItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.Stakeholder} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StakeholderItemProvider stakeholderItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStakeholderAdapter() {
		if (stakeholderItemProvider == null) {
			stakeholderItemProvider = new StakeholderItemProvider(this);
		}

		return stakeholderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.FloatConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FloatConstraintItemProvider floatConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.FloatConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFloatConstraintAdapter() {
		if (floatConstraintItemProvider == null) {
			floatConstraintItemProvider = new FloatConstraintItemProvider(this);
		}

		return floatConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.MinConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MinConstraintItemProvider minConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.MinConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMinConstraintAdapter() {
		if (minConstraintItemProvider == null) {
			minConstraintItemProvider = new MinConstraintItemProvider(this);
		}

		return minConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.URLConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected URLConstraintItemProvider urlConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.URLConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createURLConstraintAdapter() {
		if (urlConstraintItemProvider == null) {
			urlConstraintItemProvider = new URLConstraintItemProvider(this);
		}

		return urlConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.NotNullConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotNullConstraintItemProvider notNullConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.NotNullConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNotNullConstraintAdapter() {
		if (notNullConstraintItemProvider == null) {
			notNullConstraintItemProvider = new NotNullConstraintItemProvider(this);
		}

		return notNullConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.RegexpConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegexpConstraintItemProvider regexpConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.RegexpConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRegexpConstraintAdapter() {
		if (regexpConstraintItemProvider == null) {
			regexpConstraintItemProvider = new RegexpConstraintItemProvider(this);
		}

		return regexpConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.OCLConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLConstraintItemProvider oclConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.OCLConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOCLConstraintAdapter() {
		if (oclConstraintItemProvider == null) {
			oclConstraintItemProvider = new OCLConstraintItemProvider(this);
		}

		return oclConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.IntegerConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerConstraintItemProvider integerConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.IntegerConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerConstraintAdapter() {
		if (integerConstraintItemProvider == null) {
			integerConstraintItemProvider = new IntegerConstraintItemProvider(this);
		}

		return integerConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.MaxConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MaxConstraintItemProvider maxConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.MaxConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMaxConstraintAdapter() {
		if (maxConstraintItemProvider == null) {
			maxConstraintItemProvider = new MaxConstraintItemProvider(this);
		}

		return maxConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.EMailConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMailConstraintItemProvider eMailConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.EMailConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEMailConstraintAdapter() {
		if (eMailConstraintItemProvider == null) {
			eMailConstraintItemProvider = new EMailConstraintItemProvider(this);
		}

		return eMailConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.FormatConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormatConstraintItemProvider formatConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.FormatConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFormatConstraintAdapter() {
		if (formatConstraintItemProvider == null) {
			formatConstraintItemProvider = new FormatConstraintItemProvider(this);
		}

		return formatConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.Activity} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityItemProvider activityItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.Activity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActivityAdapter() {
		if (activityItemProvider == null) {
			activityItemProvider = new ActivityItemProvider(this);
		}

		return activityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.ActivityTransition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityTransitionItemProvider activityTransitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.ActivityTransition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActivityTransitionAdapter() {
		if (activityTransitionItemProvider == null) {
			activityTransitionItemProvider = new ActivityTransitionItemProvider(this);
		}

		return activityTransitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.OrganisationalUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrganisationalUnitItemProvider organisationalUnitItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.OrganisationalUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOrganisationalUnitAdapter() {
		if (organisationalUnitItemProvider == null) {
			organisationalUnitItemProvider = new OrganisationalUnitItemProvider(this);
		}

		return organisationalUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.Actor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorItemProvider actorItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.Actor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActorAdapter() {
		if (actorItemProvider == null) {
			actorItemProvider = new ActorItemProvider(this);
		}

		return actorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.ACResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ACResourceItemProvider acResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.ACResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createACResourceAdapter() {
		if (acResourceItemProvider == null) {
			acResourceItemProvider = new ACResourceItemProvider(this);
		}

		return acResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.Authorization} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuthorizationItemProvider authorizationItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.Authorization}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAuthorizationAdapter() {
		if (authorizationItemProvider == null) {
			authorizationItemProvider = new AuthorizationItemProvider(this);
		}

		return authorizationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.m2ling.domain.core.Root} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootItemProvider rootItemProvider;

	/**
	 * This creates an adapter for a {@link org.m2ling.domain.core.Root}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRootAdapter() {
		if (rootItemProvider == null) {
			rootItemProvider = new RootItemProvider(this);
		}

		return rootItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (componentTypeItemProvider != null) componentTypeItemProvider.dispose();
		if (componentItemProvider != null) componentItemProvider.dispose();
		if (componentNodeItemProvider != null) componentNodeItemProvider.dispose();
		if (viewPointItemProvider != null) viewPointItemProvider.dispose();
		if (componentGroupItemProvider != null) componentGroupItemProvider.dispose();
		if (componentNodeGroupItemProvider != null) componentNodeGroupItemProvider.dispose();
		if (viewItemProvider != null) viewItemProvider.dispose();
		if (hasCommentItemProvider != null) hasCommentItemProvider.dispose();
		if (hasCustomPropertiesItemProvider != null) hasCustomPropertiesItemProvider.dispose();
		if (customPropertyItemProvider != null) customPropertyItemProvider.dispose();
		if (linkTypeItemProvider != null) linkTypeItemProvider.dispose();
		if (linkItemProvider != null) linkItemProvider.dispose();
		if (streamItemProvider != null) streamItemProvider.dispose();
		if (stakeholderItemProvider != null) stakeholderItemProvider.dispose();
		if (floatConstraintItemProvider != null) floatConstraintItemProvider.dispose();
		if (minConstraintItemProvider != null) minConstraintItemProvider.dispose();
		if (urlConstraintItemProvider != null) urlConstraintItemProvider.dispose();
		if (notNullConstraintItemProvider != null) notNullConstraintItemProvider.dispose();
		if (regexpConstraintItemProvider != null) regexpConstraintItemProvider.dispose();
		if (oclConstraintItemProvider != null) oclConstraintItemProvider.dispose();
		if (integerConstraintItemProvider != null) integerConstraintItemProvider.dispose();
		if (maxConstraintItemProvider != null) maxConstraintItemProvider.dispose();
		if (eMailConstraintItemProvider != null) eMailConstraintItemProvider.dispose();
		if (formatConstraintItemProvider != null) formatConstraintItemProvider.dispose();
		if (activityItemProvider != null) activityItemProvider.dispose();
		if (activityTransitionItemProvider != null) activityTransitionItemProvider.dispose();
		if (organisationalUnitItemProvider != null) organisationalUnitItemProvider.dispose();
		if (actorItemProvider != null) actorItemProvider.dispose();
		if (acResourceItemProvider != null) acResourceItemProvider.dispose();
		if (authorizationItemProvider != null) authorizationItemProvider.dispose();
		if (rootItemProvider != null) rootItemProvider.dispose();
	}

}
