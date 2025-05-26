// Welcome message when page loads
document.addEventListener('DOMContentLoaded', function() {
    console.log('Welcome to the Community Portal');
    alert('Welcome to our Community Event Portal!');
    
    // Load saved preferences
    loadUserPreferences();

    // Add click event listeners to all download buttons
    const downloadButtons = document.querySelectorAll('.btn-primary');
    
    downloadButtons.forEach(button => {
        button.addEventListener('click', function(e) {
            const fileName = this.getAttribute('href');
            console.log(`Downloading ${fileName}...`);
            
            // You can add additional functionality here, such as:
            // - Download tracking
            // - Analytics
            // - Preview functionality
        });
    });

    // Add search functionality
    const searchInput = document.createElement('input');
    searchInput.type = 'text';
    searchInput.className = 'form-control mb-4';
    searchInput.placeholder = 'Search documents...';
    
    const container = document.querySelector('.container .row .col-md-12');
    container.insertBefore(searchInput, document.querySelector('.document-list'));

    searchInput.addEventListener('input', function(e) {
        const searchTerm = e.target.value.toLowerCase();
        const cards = document.querySelectorAll('.card');
        
        cards.forEach(card => {
            const title = card.querySelector('.card-title').textContent.toLowerCase();
            const text = card.querySelector('.card-text').textContent.toLowerCase();
            
            if (title.includes(searchTerm) || text.includes(searchTerm)) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });
    });
});

// Event registration handling
function registerEvent(eventType) {
    const eventForm = document.getElementById('eventForm');
    eventForm.scrollIntoView({ behavior: 'smooth' });
    document.getElementById('eventType').value = eventType;
}

// Form submission handling
function handleSubmit(event) {
    event.preventDefault();
    
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const eventType = document.getElementById('eventType').value;
    const message = document.getElementById('message').value;

    // Save preferences
    saveUserPreferences(eventType);

    // Show confirmation
    const confirmation = document.getElementById('confirmation');
    confirmation.textContent = `Thank you ${name}! You have successfully registered for the ${eventType} event.`;

    // Clear form
    event.target.reset();
    
    return false;
}

// Update fee based on event selection
function updateFee() {
    const eventType = document.getElementById('eventType').value;
    const fees = {
        'workshop': '$25',
        'concert': '$35',
        'food': '$45'
    };
    
    const confirmation = document.getElementById('confirmation');
    if (eventType) {
        confirmation.textContent = `Event Fee: ${fees[eventType]}`;
    } else {
        confirmation.textContent = '';
    }
}

// Geolocation for nearby events
function findNearbyEvents() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
            function(position) {
                const lat = position.coords.latitude;
                const lon = position.coords.longitude;
                alert(`Finding events near you...\nYour location: ${lat}, ${lon}`);
            },
            function(error) {
                switch(error.code) {
                    case error.PERMISSION_DENIED:
                        alert("Please enable location services to find nearby events.");
                        break;
                    case error.POSITION_UNAVAILABLE:
                        alert("Location information is unavailable.");
                        break;
                    case error.TIMEOUT:
                        alert("The request to get your location timed out.");
                        break;
                    default:
                        alert("An unknown error occurred.");
                        break;
                }
            },
            {
                enableHighAccuracy: true,
                timeout: 5000,
                maximumAge: 0
            }
        );
    } else {
        alert("Geolocation is not supported by your browser.");
    }
}

// Local Storage for user preferences
function saveUserPreferences(eventType) {
    localStorage.setItem('preferredEvent', eventType);
}

function loadUserPreferences() {
    const preferredEvent = localStorage.getItem('preferredEvent');
    if (preferredEvent) {
        document.getElementById('eventType').value = preferredEvent;
        updateFee();
    }
}

// Form validation
document.getElementById('name').addEventListener('blur', function() {
    if (this.value.length < 2) {
        this.setCustomValidity('Name must be at least 2 characters long');
    } else {
        this.setCustomValidity('');
    }
});

document.getElementById('email').addEventListener('blur', function() {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(this.value)) {
        this.setCustomValidity('Please enter a valid email address');
    } else {
        this.setCustomValidity('');
    }
});

// Character count for message
document.getElementById('message').addEventListener('keyup', function() {
    const maxLength = 200;
    const currentLength = this.value.length;
    const remaining = maxLength - currentLength;
    
    if (remaining < 0) {
        this.value = this.value.substring(0, maxLength);
    }
});

// Warn user before leaving form page
window.addEventListener('beforeunload', function(e) {
    const form = document.getElementById('eventForm');
    if (form && form.checkValidity()) {
        e.preventDefault();
        e.returnValue = '';
    }
}); 