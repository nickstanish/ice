/*******************************************************************************
 * Copyright (c) 2015 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jordan Deyton - Initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.eclipse.ice.viz.service.paraview.proxy;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * This provides a base class for implementing an {@link IParaViewProxyBuilder}.
 * Sub-classes need only do the following:
 * <ol>
 * <li>In their constructor, add supported extensions to {@link #extensions}.</li>
 * <li>Implement {@link #createConcreteProxy(URI)}.</li>
 * </ol>
 * 
 * @author Jordan Deyton
 *
 */
public abstract class AbstractParaViewProxyBuilder implements
		IParaViewProxyBuilder {

	/**
	 * The set of extensions supported by this proxy builder.
	 */
	protected final Set<String> extensions;

	/**
	 * The default constructor. Initializes an empty map of supported
	 * {@link #extensions}.
	 */
	protected AbstractParaViewProxyBuilder() {
		// Create an populate the set of supported extensions.
		extensions = new HashSet<String>();
	}

	/*
	 * Implements a method from IParaViewProxyBuilder.
	 */
	@Override
	public Set<String> getExtensions() {
		// Return a lexicographically ordered set.
		return new TreeSet<String>(extensions);
	}

	/*
	 * Implements a method from IParaViewProxyBuilder.
	 */
	@Override
	public IParaViewProxy createProxy(URI uri) throws NullPointerException,
			IllegalArgumentException {
		// Throw an NPE for null URIs.
		if (uri == null) {
			throw new NullPointerException("ParaViewProxyBuilder error: "
					+ "The specified URI cannot be null.");
		}

		// If possible, determine the extension of the URI. Make it lower
		// case, as case should not matter.
		String extension = "";
		try {
			String path = uri.getPath();
			extension = path.substring(path.lastIndexOf(".") + 1).toLowerCase();
		} catch (IndexOutOfBoundsException e) {
			// Nothing to do.
		}

		// Throw an exception if the extension is not supported or could not be
		// found.
		if (!extensions.contains(extension)) {
			if (extension.isEmpty()) {
				throw new IllegalArgumentException(
						"ParaViewProxyBuilder error: "
								+ "An extension for the specified URI could not be found.");
			} else {
				throw new IllegalArgumentException(
						"ParaViewProxyBuilder error: "
								+ "The specified extension \"" + extension
								+ "\" is not supported.");
			}
		}

		// If no exception was thrown, call the sub-class' implementation.
		return createConcreteProxy(uri);
	}

	/**
	 * Creates a specialized proxy for the file. When this method is called, the
	 * URI's extension will have already been validated.
	 * 
	 * @param uri
	 *            The uri that needs a new proxy. Implementations may assume
	 *            that this is not {@code null} and that its extension is in
	 *            {@link #extensions}.
	 * @return The new, specialized proxy, or {@code null} if the proxy cannot
	 *         be created for any particular reason.
	 * @see #createProxy(URI)
	 */
	protected abstract IParaViewProxy createConcreteProxy(URI uri);
}