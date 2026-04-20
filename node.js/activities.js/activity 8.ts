// 1. Define the enum for UserRole
enum UserRole {
    Admin = "Admin",
    Editor = "Editor",
    Viewer = "Viewer"
}

// 2. Use Record<UserRole, string> to map roles to descriptions
const roleDescriptions: Record<UserRole, string> = {
    [UserRole.Admin]: "Has full access to all settings and data.",
    [UserRole.Editor]: "Can edit and publish content, but cannot manage users.",
    [UserRole.Viewer]: "Can only read and view content."
};

// Example Usage:
function getRoleInfo(role: UserRole) {
    console.log(`Role: ${role}`);
    console.log(`Description: ${roleDescriptions[role]}`);
}

getRoleInfo(UserRole.Admin);

export { UserRole, roleDescriptions };
