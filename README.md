# youchen_miao_p1
Reimbursement Management System

## User story
Employees can:
* Log in to an existing account.
* View his own Reimbursements
* Submit Reimbursement requests
* Decline Reimbursements that has been changed by BENCO
* Provide additional information when requested by managers
* Provide grade achieved/presentation given for Reimbursements

Managers can:
* Request additional Info from applicant
* Request additional Info from previously signed managers
* Provide additional Info for upper managers
* Sign Reimbursements
* Decline Reimbursements
* Confirm Presentations
* View Reimbursements that exceed yearly allowed amount 
* Confirm Grades(BENCO)
* Change Reimbursement amount(BENCO)
## Implementation decisions:
* Employees can only revoke a Reimbursement if the amount has been changed by BENCO
* Employees can only upload their grade after collecting all 3 signs from direct manager, department head, BENCO: Realistically they won't get a grade until event ends and form is supposed to be signed before event starts.
* Managers can only achieve their user story on Reimbursements that they are signing, once they have signed it they lose the priviledge to request info/resign/decline a Reimbursement.
* BENCO will be able to decline a Reimbursement in every stage unless it has already been declined or granted.
## Optional bonus implemented:
* Automatically sign for direct manager and department head if they did not sign in 3 days
* Log4j logging
* Users stay logged in until they log out(even after they close the web browser, this is achieved with cookies)
* Loading bar when html makes asynchronous call to retrieve data from database
* Input validation (on the server side)
## Optional bonus not implemented:
* File transmission
* Email handling
* JUnit test
## Future improvement:
* Better UX design
