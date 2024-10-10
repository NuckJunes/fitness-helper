const ROOT = 'http://localhost:8080';

// Converts JSON data to Object
const parseJSON = (response: any) => {
    if(response.status === 204 || response.status === 205) {
        return null;
    }
    return response.json();
};

/* 
 * Checks status of API call response
 * If the response is not 200, throw an error
 */
const checkStatus = (response: any) => {
    if(response.status >= 200 && response.status < 300) {
        return response;
    }
    const error: any = new Error(response.statusText);
    error.response = response;
    throw error;
}

/*
 * A function that allows for all CRUD operations to be called
 *
 * @param string operation: The method for the call (GET, POST, DELETE, PATCH)
 * @param String endpoint: The endpoint of the api call (ex: /login, /workout, etc...)
 * @param String[] options: A list of options for the URL (ex: /profileID/exercises)
 *                          *options must be IN ORDER left to right to work*
 * @param {object} optionsBody: A object containing any values that go into the request body
 */
export const CRUD = (operation: string, endpoint: String, options: String[], optionsBody: any) => {
    let URL = ROOT + "/" + endpoint;
    options.forEach((element) => {
        URL = URL + '/' + element;
    });

    if(operation === "GET") {
        return fetch(URL, {
            method: operation,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(checkStatus)
        .then(parseJSON);
    }
    else {
        return fetch(URL, {
            method: operation,
            body: JSON.stringify(optionsBody),
            headers: {
                'Content-Type': 'application/json'
            },
        })
        .then(checkStatus)
        .then(parseJSON);
    }
};
