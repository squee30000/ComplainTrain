use complaintraincore;


--Query for selecting the body and category alias of all complaints
SELECT complaintBody, catgAlias
FROM complaint c, complaintCategory cg, category g
WHERE c.complaintID = cg.complaintID 
	AND cg.categoryID = g.categID; 
	

--Same as above but adds name associated if any	
SELECT complaintBody, catgAlias, FName, LName
FROM complaint c, complaintCategory cg, category g, employee e, complaintemployee ce
WHERE c.complaintID = cg.complaintID 
	AND cg.categoryID = g.categID
	AND c.complaintID=ce.complaintID
	AND ce.employeeID = e.employeeID; 