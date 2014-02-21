create index IX_13BD274A on SRB_Event (companyId, status);
create index IX_DF770184 on SRB_Event (companyId, userId, status);
create index IX_5317DBE6 on SRB_Event (groupId);
create index IX_94C6D4CC on SRB_Event (groupId, status);
create index IX_D1440D06 on SRB_Event (groupId, userId, status);
create index IX_561F2FF0 on SRB_Event (uuid_);
create index IX_A1E27E38 on SRB_Event (uuid_, companyId);
create unique index IX_3FE532BA on SRB_Event (uuid_, groupId);