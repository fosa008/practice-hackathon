const API_URL = window.location.origin;
async function submitData() {
    const rawInput = document.getElementById('featureData').value;
    if (!rawInput) return;
    await fetch(`${API_URL}/api/predict`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ features: rawInput })
    });
    document.getElementById('featureData').value = '';
    fetchHistory();
}
async function fetchHistory() {
    const response = await fetch(`${API_URL}/api/records`);
    const list = await response.json();
    const tbody = document.getElementById('tableBody');
    tbody.innerHTML = '';
    list.forEach(row => {
        tbody.innerHTML += `<tr><td>${row.id}</td><td>${row.features}</td><td>${row.predictionValue.toFixed(2)}</td><td>${row.status}</td></tr>`;
    });
}
window.onload = fetchHistory;
