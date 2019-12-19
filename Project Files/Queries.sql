use complaintraincore;


--Query for selecting the body and category alias of all complaints
SELECT complaintBody, catgAlias
FROM complaint c, complaintCategory cg, category g
WHERE c.complaintID = cg.complaintID 
	AND cg.categoryID = g.categID; 
	

--Same as above but adds name associated if any	
SELECT complaintBody, catgAlias, FName, LName
FROM complaint c, complaintCategory cg, category g, employee e
WHERE c.complaintID = cg.complaintID 
	AND cg.categoryID = g.categID
	AND c.complaintEmployee = e.employeeID; 
	
	
SELECT complaintBody, catgAlias
FROM complaint c, complaintCategory cg, category g, employee e
WHERE c.complaintID = cg.complaintID 
	AND e.employeeID = c.complaintEmployee
	AND cg.categoryID = g.categID; 