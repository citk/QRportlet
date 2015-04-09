create table order_kunde (
	kundeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	kundeDescription VARCHAR(100) null,
	userKunde VARCHAR(30) null,
	userDocument LONG,
	userCity VARCHAR(30) null,
	userEmail VARCHAR(50) null,
	folderDLId LONG
);