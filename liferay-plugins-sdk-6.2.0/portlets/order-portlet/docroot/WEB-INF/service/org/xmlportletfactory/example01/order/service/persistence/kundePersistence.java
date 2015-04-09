/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.xmlportletfactory.example01.order.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.xmlportletfactory.example01.order.model.kunde;

/**
 * The persistence interface for the kunde service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see kundePersistenceImpl
 * @see kundeUtil
 * @generated
 */
public interface kundePersistence extends BasePersistence<kunde> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link kundeUtil} to access the kunde persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the kundes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kundes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @return the range of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kundes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kunde in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns the first kunde in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kunde, or <code>null</code> if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kunde in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns the last kunde in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kunde, or <code>null</code> if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kundes before and after the current kunde in the ordered set where groupId = &#63;.
	*
	* @param kundeId the primary key of the current kunde
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde[] findByGroupId_PrevAndNext(
		long kundeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns all the kundes that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching kundes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kundes that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @return the range of matching kundes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kundes that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kundes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kundes before and after the current kunde in the ordered set of kundes that the user has permission to view where groupId = &#63;.
	*
	* @param kundeId the primary key of the current kunde
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde[] filterFindByGroupId_PrevAndNext(
		long kundeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Removes all the kundes where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kundes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kundes that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching kundes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kundes where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kundes where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @return the range of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kundes where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kunde in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde findByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns the first kunde in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kunde, or <code>null</code> if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kunde in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde findByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns the last kunde in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kunde, or <code>null</code> if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kundes before and after the current kunde in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param kundeId the primary key of the current kunde
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde[] findByUserIdGroupId_PrevAndNext(
		long kundeId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns all the kundes that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching kundes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> filterFindByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kundes that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @return the range of matching kundes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kundes that the user has permissions to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kundes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kundes before and after the current kunde in the ordered set of kundes that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param kundeId the primary key of the current kunde
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde[] filterFindByUserIdGroupId_PrevAndNext(
		long kundeId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Removes all the kundes where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kundes where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kundes that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching kundes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kundes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kundes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @return the range of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kundes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kunde in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns the first kunde in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kunde, or <code>null</code> if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kunde in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns the last kunde in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kunde, or <code>null</code> if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kundes before and after the current kunde in the ordered set where userId = &#63;.
	*
	* @param kundeId the primary key of the current kunde
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde[] findByUserId_PrevAndNext(
		long kundeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Removes all the kundes where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kundes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kundes where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kundes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @return the range of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kundes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kunde in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns the first kunde in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kunde, or <code>null</code> if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kunde in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns the last kunde in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kunde, or <code>null</code> if a matching kunde could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kundes before and after the current kunde in the ordered set where companyId = &#63;.
	*
	* @param kundeId the primary key of the current kunde
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde[] findByCompanyId_PrevAndNext(
		long kundeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Removes all the kundes where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kundes where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching kundes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the kunde in the entity cache if it is enabled.
	*
	* @param kunde the kunde
	*/
	public void cacheResult(
		org.xmlportletfactory.example01.order.model.kunde kunde);

	/**
	* Caches the kundes in the entity cache if it is enabled.
	*
	* @param kundes the kundes
	*/
	public void cacheResult(
		java.util.List<org.xmlportletfactory.example01.order.model.kunde> kundes);

	/**
	* Creates a new kunde with the primary key. Does not add the kunde to the database.
	*
	* @param kundeId the primary key for the new kunde
	* @return the new kunde
	*/
	public org.xmlportletfactory.example01.order.model.kunde create(
		long kundeId);

	/**
	* Removes the kunde with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kundeId the primary key of the kunde
	* @return the kunde that was removed
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde remove(
		long kundeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	public org.xmlportletfactory.example01.order.model.kunde updateImpl(
		org.xmlportletfactory.example01.order.model.kunde kunde)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kunde with the primary key or throws a {@link org.xmlportletfactory.example01.order.NoSuchkundeException} if it could not be found.
	*
	* @param kundeId the primary key of the kunde
	* @return the kunde
	* @throws org.xmlportletfactory.example01.order.NoSuchkundeException if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde findByPrimaryKey(
		long kundeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.example01.order.NoSuchkundeException;

	/**
	* Returns the kunde with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param kundeId the primary key of the kunde
	* @return the kunde, or <code>null</code> if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.example01.order.model.kunde fetchByPrimaryKey(
		long kundeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kundes.
	*
	* @return the kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kundes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @return the range of kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kundes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of kundes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the kundes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kundes.
	*
	* @return the number of kundes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}