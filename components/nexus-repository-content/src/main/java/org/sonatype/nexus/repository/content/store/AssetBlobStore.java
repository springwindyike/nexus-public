/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.repository.content.store;

import java.util.Collection;
import java.util.Optional;

import org.sonatype.nexus.blobstore.api.BlobRef;
import org.sonatype.nexus.datastore.api.DataSessionSupplier;
import org.sonatype.nexus.repository.content.AssetBlob;
import org.sonatype.nexus.transaction.Transactional;

/**
 * {@link AssetBlob} store.
 *
 * @since 3.next
 */
public abstract class AssetBlobStore<T extends AssetBlobDAO>
    extends ContentStoreSupport<T>
{
  public AssetBlobStore(final DataSessionSupplier sessionSupplier, final String storeName) {
    super(sessionSupplier, storeName);
  }

  /**
   * Browse unused blob references in the content data store.
   */
  @Transactional
  public Collection<BlobRef> browseUnusedBlobs() {
    return dao().browseUnusedBlobs();
  }

  /**
   * Creates the given asset blob in the content data store.
   *
   * @param assetBlob the asset blob to create
   */
  @Transactional
  public void createAssetBlob(final AssetBlobData assetBlob) {
    dao().createAssetBlob(assetBlob);
  }

  /**
   * Retrieves an asset blob from the content data store.
   *
   * @param blobRef the blob reference
   * @return asset blob if it was found
   */
  @Transactional
  public Optional<AssetBlob> readAssetBlob(final BlobRef blobRef) {
    return dao().readAssetBlob(blobRef);
  }

  /**
   * Deletes an asset blob from the content data store.
   *
   * @param blobRef the blob reference
   * @return {@code true} if the asset blob was deleted
   */
  @Transactional
  public boolean deleteAssetBlob(final BlobRef blobRef) {
    return dao().deleteAssetBlob(blobRef);
  }
}
