const base = "http://localhost:8083";

function fetchStudents() {
  fetch(`${base}/students`)
    .then(res => res.json())
    .then(data => {
      const list = document.getElementById("studentList");
      list.innerHTML = "";
      data.forEach(std => {
        const div = document.createElement("div");
        div.innerHTML = `
          ${std.studentId}: ${std.stdName} (${std.stdEmail})
          <button onclick="deleteStudent(${std.studentId})">Delete</button>
        `;
        list.appendChild(div);
      });
    });
}

function addStudent() {
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;

  if (!name || !email) {
    alert("Please enter both name and email.");
    return;
  }

  fetch(`${base}/students`, {
    method: "POST",
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ stdName: name, stdEmail: email })
  }).then(() => {
    fetchStudents();
    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
  });
}

function deleteStudent(id) {
  fetch(`${base}/students/${id}`, { method: "DELETE" })
    .then(fetchStudents)
    .then(fetchAttendance);
}

function markAttendance() {
  const studentId = document.getElementById("attendId").value;
  const date = document.getElementById("date").value;
  const present = document.getElementById("present").value;

  if (!studentId || !date) {
    alert("Please enter both Student ID and Date.");
    return;
  }

  fetch(`${base}/attendance`, {
    method: "POST",
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ studentId, date, present })
  }).then(() => {
    fetchAttendance();
    document.getElementById("attendId").value = "";
    document.getElementById("date").value = "";
    document.getElementById("present").value = "true";
  });
}

function fetchAttendance() {
  fetch(`${base}/attendance/pivot`)
    .then(response => response.json())
    .then(data => {
      const dates = new Set();
      data.forEach(student => {
        Object.keys(student.attendance).forEach(date => dates.add(date));
      });

      const sortedDates = Array.from(dates).sort();

      let html = "<thead><tr><th>ID</th><th>Student Name</th>";
      sortedDates.forEach(date => {
        html += `<th>${date}</th>`;
      });
      html += "</tr></thead><tbody>";

      data.forEach(student => {
        html += `<tr><td>${student.studentId}</td><td>${student.studentName}</td>`;
        sortedDates.forEach(date => {
          const status = student.attendance[date] || "-";
          html += `<td>${status}</td>`;
        });
        html += "</tr>";
      });

      html += "</tbody>";
      document.getElementById("pivotTable").innerHTML = html;
    });
}

fetchStudents();
fetchAttendance();
