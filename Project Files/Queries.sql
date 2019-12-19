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
	
SELECT complaintBody, FName, LName
FROM complaint c, employee e
WHERE c.complaintResolution = 0
	AND c.complaintEmployee = e.employeeID; 
	
	
SELECT complaintBody
FROM complaint c
WHERE c.complaintResolution <> 1
	AND c.complaintID NOT IN(
		SELECT complaintBody, FName, LName
		FROM complaint c, employee e
		WHERE c.complaintID = cg.complaintID 
			AND c.complaintResolution = 0
			AND c.complaintEmployee = e.employeeID
	);