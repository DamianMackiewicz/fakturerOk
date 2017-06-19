function doRestPost() {
    document.getElementById('response').value = null;
    var url = getHost() + getUrl();
    var response = httpPost(url, getPostBody());
    document.getElementById('response').value = JSON.stringify(JSON.parse(response), null, 2);
    storeReq('POST');
}

function doRestGet() {
    document.getElementById('response').value = null;
    var url = getHost() + getUrl();
    var response = httpGet(url);
    document.getElementById('response').value = JSON.stringify(JSON.parse(response), null, 2);
    storeReq('GET');
}

function storeReq(method) {
    var counter = localStorage.getItem('counter');
    var reqId = 'req' + counter;
    var req = {id: reqId, method:method, host:getHost(), url:getUrl(), body:getPostBody()};
    localStorage.setItem(reqId, JSON.stringify(req));
    counter++;
    localStorage.setItem('counter', counter);
    addReqToView(req);
}

function addReqToView(req) {
    var s = '<div style="margin-bottom:10px;border:solid 1px; padding: 2px"><span><b>' + req.method + '</b> ' + req.host + req.url +'</span><br>' +
        '<span>' + (req.body ? JSON.stringify(req.body, null, 2) : '') + '</span><br>' +
        '<button onclick="loadReq(\'' + req.id + '\')">Wczytaj</button>&nbsp;&nbsp;&nbsp;<button onclick="deleteReq(\'' + req.id + '\')">Usuń</button></div>';

    var li = document.createElement('li');
    li.id = req.id;
    li.innerHTML = s;
    document.getElementById('req-list').appendChild(li);
}

function deleteReq(reqId) {
    localStorage.removeItem(reqId);
    document.getElementById(reqId).remove();
}

function loadReq(reqId) {
    var req = JSON.parse(localStorage.getItem(reqId));
    document.getElementById('host').value = req.host;
    document.getElementById('url').value = req.url;
    document.getElementById('post-body').value = JSON.stringify(req.body, null, 2) != 'null' ? JSON.stringify(req.body, null, 2) : null;
}

function doRestPretty() {
    document.getElementById('post-body').value = JSON.stringify(JSON.parse(document.getElementById('post-body').value), null, 2);
}

function doRestClean() {
    document.getElementById('url').value = '/api';
    document.getElementById('post-body').value = null;
    document.getElementById('response').value = null;
}

function getUrl() {
    return document.getElementById('url').value;
}

function getPostBody() {
    var val = document.getElementById('post-body').value;
    if (val) {
        return JSON.parse(val);
    } else {
        return null;
    }
}

function getHost() {
    return document.getElementById('host').value;
}

function setInitialUrl() {
    document.getElementById('url').value = '/api';
}

function setHost() {
    document.getElementById('host').value = HOST;
}

function initStore() {
    var counter = localStorage.getItem('counter');
    if (counter == undefined || counter == null) {
        localStorage.setItem('counter', 1);
    }
}

function displayAllFromStore() {
    for (var key in localStorage){
        if (key.match(/req.*/)) {
            addReqToView(JSON.parse(localStorage.getItem(key)));
        }
    }
}

function resetStore() {
    for (var key in localStorage){
        if (key.match(/req.*/)) {
            deleteReq(key);
        }
    }
    localStorage.setItem('counter', 1);
}