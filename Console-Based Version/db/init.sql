CREATE DATABASE crisiscompass;
USE crisiscompass;

-- Users Table
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contact_number VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Help Requests Table
CREATE TABLE HelpRequests (
    request_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    disaster_type VARCHAR(50),
    request_details TEXT,
    status ENUM('Pending', 'In Progress', 'Resolved') DEFAULT 'Pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- Disaster Tips Table
CREATE TABLE DisasterTips (
    tip_id INT AUTO_INCREMENT PRIMARY KEY,
    disaster_type VARCHAR(50),
    category ENUM('Preparation', 'During', 'After', 'Emergency'),
    tip_text TEXT NOT NULL
);


CREATE TABLE PredefinedInventory (
    itemId INT AUTO_INCREMENT PRIMARY KEY,
    itemName VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL, 
    description TEXT NOT NULL,
    essential BOOLEAN NOT NULL,
    applicableDisasters VARCHAR(255) 
);

INSERT INTO PredefinedInventory (itemName, category, description, essential, applicableDisasters)
VALUES
('Canned Food', 'Food', 'Non-perishable canned food for sustenance.', true, 'Flood,Earthquake,Typhoon'),
('First Aid Kit', 'Medicine', 'Basic medical supplies for emergency care.', true, 'Flood,Earthquake,Typhoon,Volcanic Eruption'),
('Flashlight', 'Tool', 'Battery-powered flashlight for visibility during power outages.', true, 'Earthquake,Typhoon'),
('Batteries', 'Tool', 'Backup batteries for devices like flashlights.', true, 'Earthquake,Typhoon'),
('Blanket', 'Clothing', 'Warm blankets to prevent hypothermia.', true, 'Flood,Typhoon'),
('Portable Stove', 'Tool', 'Compact stove for cooking when electricity is unavailable.', false, 'Flood,Typhoon'),
('Water Purification Tablets', 'Medicine', 'Tablets for purifying contaminated water.', true, 'Flood,Typhoon, Drought'),
('Emergency Radio', 'Tool', 'Radio for receiving weather and disaster updates.', true, 'Flood,Typhoon,Volcanic Eruption'),
('Tent', 'Shelter', 'Portable tent for temporary shelter.', false, 'Typhoon,Flood'),
('Fire Extinguisher', 'Tool', 'Device to extinguish small fires.', true, 'Volcanic Eruption,Typhoon, Drought'),
('Sandbags', 'Tool', 'Used to block water in flood-prone areas.', false, 'Flood,Typhoon'),
('Face Masks', 'Medical', 'Masks to prevent inhalation of smoke or dust.', true, 'Volcanic Eruption,Earthquake'),
('Rope', 'Tool', 'Multi-purpose rope for rescue and securing items.', false, 'Flood,Typhoon'),
('Gloves', 'Clothing', 'Protective gloves for handling debris.', true, 'Earthquake,Volcanic Eruption'),
('Sleeping Bag', 'Clothing', 'Portable sleeping bag for comfort and warmth.', true, 'Flood,Typhoon');


INSERT INTO DisasterTips (disaster_type, category, tip_text) VALUES
-- Drought Tips
('Drought', 'Preparation', 'Store enough water for drinking and daily use.'),
('Drought', 'Preparation', 'Install water-efficient appliances.'),
('Drought', 'Preparation', 'Plant drought-resistant crops.'),
('Drought', 'Preparation', 'Repair leaks in pipes and faucets promptly.'),
('Drought', 'Preparation', 'Use mulching to reduce water evaporation from soil.'),
('Drought', 'During', 'Avoid watering lawns or washing cars.'),
('Drought', 'During', 'Limit water usage to essentials only.'),
('Drought', 'During', 'Use greywater for watering plants.'),
('Drought', 'During', 'Turn off taps when not in use.'),
('Drought', 'During', 'Avoid outdoor activities that consume water.'),
('Drought', 'After', 'Monitor your water storage levels and refill as needed.'),
('Drought', 'After', 'Evaluate water-saving strategies for future use.'),
('Drought', 'After', 'Clean and maintain water storage containers.'),
('Drought', 'After', 'Advocate for local water conservation initiatives.'),
('Drought', 'After', 'Check on crops and landscaping for damage.'),
('Drought', 'Emergency', 'Reuse water whenever possible for non-drinking purposes.'),
('Drought', 'Emergency', 'Report water supply issues to authorities.'),
('Drought', 'Emergency', 'Provide water to vulnerable neighbors or animals.'),
('Drought', 'Emergency', 'Distribute water efficiently among household members.'),
('Drought', 'Emergency', 'Store emergency water supplies safely.'),

-- Earthquake Tips
('Earthquake', 'Preparation', 'Secure heavy furniture to walls.'),
('Earthquake', 'Preparation', 'Practice “Drop, Cover, and Hold On” drills.'),
('Earthquake', 'Preparation', 'Prepare an earthquake emergency kit.'),
('Earthquake', 'Preparation', 'Identify safe spots in each room.'),
('Earthquake', 'Preparation', 'Know how to turn off gas and electricity.'),
('Earthquake', 'During', 'Move away from windows and heavy objects.'),
('Earthquake', 'During', 'Stay indoors and under sturdy furniture.'),
('Earthquake', 'During', 'Do not use elevators.'),
('Earthquake', 'During', 'Protect your head and neck with your arms.'),
('Earthquake', 'During', 'If outside, move to an open area away from buildings.'),
('Earthquake', 'After', 'Check yourself and others for injuries.'),
('Earthquake', 'After', 'Be cautious of aftershocks.'),
('Earthquake', 'After', 'Inspect your home for structural damage.'),
('Earthquake', 'After', 'Avoid damaged buildings.'),
('Earthquake', 'After', 'Document damages for insurance claims.'),
('Earthquake', 'Emergency', 'Use a whistle to signal for help.'),
('Earthquake', 'Emergency', 'Call for emergency services if trapped.'),
('Earthquake', 'Emergency', 'Communicate your location to rescuers.'),
('Earthquake', 'Emergency', 'Stay calm and provide first aid if trained.'),
('Earthquake', 'Emergency', 'Conserve phone battery for emergencies.'),

-- Flood Tips
('Flood', 'Preparation', 'Elevate appliances and valuables.'),
('Flood', 'Preparation', 'Prepare an emergency kit.'),
('Flood', 'Preparation', 'Learn evacuation routes.'),
('Flood', 'Preparation', 'Install flood barriers if necessary.'),
('Flood', 'Preparation', 'Keep insurance documents safe and accessible.'),
('Flood', 'During', 'Evacuate immediately if instructed.'),
('Flood', 'During', 'Avoid walking or driving in floodwaters.'),
('Flood', 'During', 'Move to higher ground immediately.'),
('Flood', 'During', 'Stay away from electrical equipment.'),
('Flood', 'During', 'Keep listening to local updates.'),
('Flood', 'After', 'Clean and disinfect everything contaminated by floodwater.'),
('Flood', 'After', 'Avoid drinking tap water until deemed safe.'),
('Flood', 'After', 'Document damages for insurance claims.'),
('Flood', 'After', 'Dispose of food exposed to floodwater.'),
('Flood', 'After', 'Monitor for waterborne diseases.'),
('Flood', 'Emergency', 'Signal for rescue using bright objects or whistles.'),
('Flood', 'Emergency', 'Provide first aid if you or others are injured.'),
('Flood', 'Emergency', 'Cooperate with rescue teams for evacuation.'),
('Flood', 'Emergency', 'Communicate your location to emergency responders.'),
('Flood', 'Emergency', 'Stay calm and alert for rising water levels.'),

-- Typhoon Tips
('Typhoon', 'Preparation', 'Reinforce doors and windows.'),
('Typhoon', 'Preparation', 'Stock up on emergency supplies.'),
('Typhoon', 'Preparation', 'Trim tree branches around your home.'),
('Typhoon', 'Preparation', 'Check the roof for loose tiles.'),
('Typhoon', 'Preparation', 'Prepare a go-bag with essential items.'),
('Typhoon', 'During', 'Stay indoors and away from windows.'),
('Typhoon', 'During', 'Turn off utilities if instructed.'),
('Typhoon', 'During', 'Secure pets in a safe location.'),
('Typhoon', 'During', 'Avoid using phones unless for emergencies.'),
('Typhoon', 'During', 'Listen to emergency instructions.'),
('Typhoon', 'After', 'Inspect your home for damage.'),
('Typhoon', 'After', 'Report power outages to utility providers.'),
('Typhoon', 'After', 'Be cautious of fallen trees and debris.'),
('Typhoon', 'After', 'Document damages for insurance claims.'),
('Typhoon', 'After', 'Clean up safely using proper protective gear.'),
('Typhoon', 'Emergency', 'Listen to emergency broadcasts for updates.'),
('Typhoon', 'Emergency', 'Contact local authorities for rescue.'),
('Typhoon', 'Emergency', 'Avoid downed power lines.'),
('Typhoon', 'Emergency', 'Provide aid to injured persons if safe.'),
('Typhoon', 'Emergency', 'Safely evacuate to a shelter if needed.'),

-- Volcanic Eruption Tips
('Volcanic Eruption', 'Preparation', 'Identify safe evacuation routes.'),
('Volcanic Eruption', 'Preparation', 'Stockpile dust masks and goggles.'),
('Volcanic Eruption', 'Preparation', 'Prepare an emergency kit with essentials.'),
('Volcanic Eruption', 'Preparation', 'Understand local volcanic alerts.'),
('Volcanic Eruption', 'Preparation', 'Protect livestock by moving them to safe areas.'),
('Volcanic Eruption', 'During', 'Cover your mouth and nose with a mask.'),
('Volcanic Eruption', 'During', 'Stay indoors and close all windows and doors.'),
('Volcanic Eruption', 'During', 'Avoid low-lying areas prone to lava flow.'),
('Volcanic Eruption', 'During', 'Wear long sleeves to protect your skin.'),
('Volcanic Eruption', 'During', 'Be alert for pyroclastic flows.'),
('Volcanic Eruption', 'After', 'Monitor for ash fall and respiratory hazards.'),
('Volcanic Eruption', 'After', 'Inspect your home for damage from ash.'),
('Volcanic Eruption', 'After', 'Remove ash carefully to avoid structural strain.'),
('Volcanic Eruption', 'After', 'Check water sources for contamination.'),
('Volcanic Eruption', 'After', 'Seek medical attention if you experience respiratory issues.'),
('Volcanic Eruption', 'Emergency', 'Follow official evacuation orders.'),
('Volcanic Eruption', 'Emergency', 'Avoid river valleys that could carry lahar.'),
('Volcanic Eruption', 'Emergency', 'Do not enter restricted zones.'),
('Volcanic Eruption', 'Emergency', 'Assist others in evacuating if possible.'),
('Volcanic Eruption', 'Emergency', 'Contact local authorities for assistance.');

