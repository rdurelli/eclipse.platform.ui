/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.ui.internal.csm.commands.api;

import java.util.Set;

/**
 * <p>
 * An instance of <code>ICommandManager</code> can be used to obtain instances
 * of <code>ICommand</code>, as well as manage whether or not those instances
 * are active or inactive, enabled or disabled.
 * </p> 
 * <p>
 * This interface is not intended to be extended or implemented by clients.
 * </p>
 * <p>
 * <em>EXPERIMENTAL</em>
 * </p>
 * 
 * @since 3.0
 * @see CommandManagerFactory
 * @see ICommand
 * @see ICommandManagerListener
 */
public interface ICommandManager {

	/**
	 * Registers an instance of <code>ICommandManagerListener</code> to listen 
	 * for changes to attributes of this instance.
	 *
	 * @param commandManagerListener the instance of 
	 *                               <code>ICommandManagerListener</code> to 
	 * 						         register. Must not be <code>null</code>. 
	 *                               If an attempt is made to register an 
	 *                               instance of 
	 *                               <code>ICommandManagerListener</code> 
	 *                               which is already registered with this 
	 *                               instance, no operation is performed.
	 */		
	void addCommandManagerListener(ICommandManagerListener commandManagerListener);

	/**
	 * <p>
	 * Returns the set of identifiers to active commands. This set is not 
	 * necessarily a subset of the set of identifiers to defined commands.
	 * </p>
	 * <p>
	 * Notification is set to all registered listeners if this attribute 
	 * changes.
	 * </p>
	 *
	 * @return the set of identifiers to active commands. This set may be 
	 *         empty, but is guaranteed not to be <code>null</code>. If this set 
	 *         is not empty, it is guaranteed to only contain instances of 
	 *         <code>String</code>.
	 */	
	Set getActiveCommandIds();

	/**
	 * Returns a handle to an command given an identifier.
	 *
	 * @param commandId an identifier. Must not be <code>null</code>
	 * @return          a handle to an command.
	 */	
	ICommand getCommand(String commandId);

	/**
	 * <p>
	 * Returns the set of identifiers to defined commands.
	 * </p>
	 * <p>
	 * Notification is set to all registered listeners if this attribute 
	 * changes.
	 * </p>
	 *
	 * @return the set of identifiers to defined commands. This set may be 
	 *         empty, but is guaranteed not to be <code>null</code>. If this set 
	 *         is not empty, it is guaranteed to only contain instances of 
	 *         <code>String</code>.
	 */	
	Set getDefinedCommandIds();

	/**
	 * <p>
	 * Returns the set of identifiers to enabled commands. This set is not 
	 * necessarily a subset of the set of identifiers to defined commands.
	 * </p>
	 * <p>
	 * Notification is set to all registered listeners if this attribute 
	 * changes.
	 * </p>
	 *
	 * @return the set of identifiers to enabled commands. This set may be 
	 *         empty, but is guaranteed not to be <code>null</code>. If this set 
	 *         is not empty, it is guaranteed to only contain instances of 
	 *         <code>String</code>.
	 */	
	Set getEnabledCommandIds();	
	
	/**
	 * Unregisters an instance of <code>ICommandManagerListener</code> 
	 * listening for changes to attributes of this instance.
	 *
	 * @param commandManagerListener the instance of 
	 *                               <code>ICommandManagerListener</code> to 
	 * 						         unregister. Must not be <code>null</code>. 
	 *                               If an attempt is made to unregister an 
	 *                               instance of 
	 *                               <code>ICommandManagerListener</code> 
	 *                               which is not already registered with this 
	 *                               instance, no operation is performed.
	 */
	void removeCommandManagerListener(ICommandManagerListener commandManagerListener);

	/**
	 * Sets the set of identifiers to active commands. 
	 *
	 * @param activeCommandIds the set of identifiers to active commands. 
	 *                         This set may be empty, but it must not be 
	 *                         <code>null</code>. If this set is not empty, it 
	 *                         must only contain instances of 
	 *                         <code>String</code>.	
	 */
	void setActiveCommandIds(Set activeCommandIds);
	
	/**
	 * Sets the set of identifiers to enabled commands. 
	 *
	 * @param enabledCommandIds the set of identifiers to enabled commands. 
	 *                          This set may be empty, but it must not be 
	 *                          <code>null</code>. If this set is not empty, it 
	 *                          must only contain instances of 
	 *                          <code>String</code>.	
	 */
	void setEnabledCommandIds(Set enabledCommandIds);		
}
