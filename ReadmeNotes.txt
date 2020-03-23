cd to the correct directory and then run using the command 'dotnet run' 
(https://docs.microsoft.com/en-us/dotnet/core/tools/dotnet-run)
which will build and run:

cd C:\Users\brian.phillips\source\repos\LifeJacket\Auth>
C:\Users\brian.phillips\source\repos\LifeJacket\Auth>dotnet run

On the dev environmnet, my port is 44375.  But in production, 
the port number will be displayed in the command line window: 

the info: Microsoft.Hosting.Lifetime[0]
      Now listening on: https://localhost:5001
info: Microsoft.Hosting.Lifetime[0]
      Now listening on: http://localhost:5000

To test run the app, then use Postman and replace the port number with the correct port i.e. <5001> (for https)
(or one of the port numbers displayed in the command line) i.e.
https://localhost:5001/api/Login

***(need to add postman config files to github for Postman tests?)***

or call with client code, or nagivate to same url in browser (or curl?)

The Post method expects a json object as a parameter that is bound using the request body.
However you will get an empty result unless passing in the proper json in POST Method of the body
For example this is what you will see in the browser with no data passed in:
// https://localhost:5001/api/login

[
  [
    
  ],
  [
    
  ],
  [
    
  ],
  [
    
  ],
  [
    
  ],
  [
    
  ],
  [
    
  ]
]

The POST() method of the LoginController expects a json structure similar to below to be posted in the body:
{
    "name": "Brandon Roberts",
    "email": "brandon.roberts@ruralsourcing.com",
    "photoUrl": "https://lh3.googleusercontent.com/a-/AAuE7mBr5bTYig1ynTCsuoVl_DIQg9i3JuNRsXk1_l4_=s96-c",
    "firstName": "Brandon",
    "lastName": "Roberts",
    "authToken": "ya29.ImC9B74V1kF_wL6VvsEG5q2Bcp7zHI49hEOAUBAkcn2JzQoNbivwejO-KUN5iNDEuJMdl3-bdPX-dGswM0x_jr1uL1YumayNB-MXqMReilk7OC9iK2mbpOoqXf936RxCBbI",
    "idToken": "eyJhbGciOiJSUzI1NiIsImtpZCI6Ijc2MmZhNjM3YWY5NTM1OTBkYjhiYjhhNjM2YmYxMWQ0MzYwYWJjOTgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiNDA3MDk4MTkzMTY3LTJlcWRrajRmZWFkY2tzcmE3ZDJibWZzaGZhNjExNTZvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiNDA3MDk4MTkzMTY3LTJlcWRrajRmZWFkY2tzcmE3ZDJibWZzaGZhNjExNTZvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA3OTgyNTQ4MzE2ODMxNzk0OTA0IiwiaGQiOiJydXJhbHNvdXJjaW5nLmNvbSIsImVtYWlsIjoiYnJheWRlbi5yb2JiaW5zQHJ1cmFsc291cmNpbmcuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiI3SWMyT1ZseGFaSjNXRHg3LTZsT2lBIiwibmFtZSI6IkJyYXlkZW4gUm9iYmlucyIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQUF1RTdtQnI1YlRZaWcxeW5UQ3N1b1ZsX0RJUWc5aTNKdU5Sc1hrMV9sNF89czk2LWMiLCJnaXZlbl9uYW1lIjoiQnJheWRlbiIsImZhbWlseV9uYW1lIjoiUm9iYmlucyIsImxvY2FsZSI6ImVuIiwiaWF0IjoxNTgyMDU3MzY3LCJleHAiOjE1ODIwNjA5NjcsImp0aSI6IjNkNWVhOWVhMzM4NzkxYTFhNjM4ZTVlZTZlMTgxYzkwNDljY2JiZjIifQ.UN_7sA3WfL6qMDfogd7cgcGkDpC3ZnxR5bChsldTz2WDxmgM-jyUr4X3cntwx81G3f7hmb9VVFb-GdO_lA4UHqjJz9DzhNyGgsTa3ffLlDy_xL3_Z5tpqfc_1OIj_oF90pJiBiurp-BKDJ175Rm7_pvnnP9M8YHp4F0P24mlUCpoJrasn8WCTTE2UC9nDmnqwmri4SR61qtheIrtveIrJK7AcwChJFjGObMHDDVVtEe23aD1dIynNKSBbKvxvW7D5ZwlVRggdBqDBFuYIhoY2w_SiR9F_MjdQDtxFpG3icf3kwENVbABzLG6rX3I8BSadsSO64yEUsAWjnIqq3M2Iw",
    "provider": "GOOGLE"
}

And will return the following if successful:
brandon.roberts@ruralsourcing.com

The GET() method of that controller has one overloaded method that 
accepts a parameter of type string and is just a query to see if the id
exists in the appropriate table.

MySql configuration notes:
https://dev.mysql.com/doc/connector-net/en/connector-net-entityframework-core-scaffold-example.html

//example scaffolding
Scaffold-DbContext "server=localhost;port=3306;user=root;password=mypass;database=sakila" MySql.Data.EntityFrameworkCore -OutputDir sakila -f

For this method/action/route:  https://localhost:44375/api/login
The Get method is currently returning the following, which is not the correct shape: 
[
    [
        "107982548316831794905",
        "1937419",
        "1A",
        "1B"
    ],
    [
        "Brandon",
        "Brayden",
        "Courtney",
        "Courtney"
    ],
    [
        "Roberts",
        "Roberts",
        "Tull",
        "Tull"
    ],
    [
        "brandon.roberts@ruralsourcing.com",
        "brayden.robbins@ruralsourcing.com",
        "courtney.tull@ruralsourcing.com",
        "courtney.tull@ruralsourcing.com"
    ],
    [
        "https://lh3.googleusercontent.com/a-/AAuE7mBr5bTYig1ynTCsuoVl_DIQg9i3JuNRsXk1_l4_=s96-c",
        "",
        "",
        ""
    ],
    [
        "",
        "",
        "",
        ""
    ],
    [
        "",
        "",
        "",
        ""
    ],
    [
        "",
        "",
        "",
        ""
    ]
]